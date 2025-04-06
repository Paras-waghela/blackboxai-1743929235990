const express = require('express');
const path = require('path');
const fs = require('fs');
const compression = require('compression');

const app = express();
const PORT = 8000;

// Production Middleware
app.use(compression());
app.use(express.json());
app.use(express.static(path.join(__dirname), {
    setHeaders: (res, filePath) => {
        const mimeTypes = {
            '.css': 'text/css',
            '.js': 'application/javascript',
            '.html': 'text/html'
        };
        const ext = path.extname(filePath);
        if (mimeTypes[ext]) {
            res.setHeader('Content-Type', mimeTypes[ext]);
        }
    }
}));

// Error handling
app.use((err, req, res, next) => {
    console.error(err.stack);
    res.status(500).sendFile(path.join(__dirname, 'public', '500.html'));
});

app.use((req, res) => {
    res.status(404).sendFile(path.join(__dirname, 'public', '404.html'));
});

// API Endpoints
app.post('/api/login', (req, res) => {
    const { username, password } = req.body;
    console.log('Login attempt:', username);
    
    // Simple validation
    if (username && password) {
        return res.json({ success: true, token: 'sample-token-123' });
    }
    res.status(401).json({ success: false, message: 'Invalid credentials' });
});

app.post('/api/patients', (req, res) => {
    const patientData = req.body;
    console.log('Creating patient:', patientData.name);
    
    // Simulate file creation
    const patientId = 'PT-' + Math.floor(1000 + Math.random() * 9000);
    res.json({ 
        success: true, 
        patientId,
        message: 'Patient record created successfully'
    });
});

app.get('/api/patients', (req, res) => {
    // Sample patient data
    const patients = [
        {
            id: 'PT-1001',
            name: 'John Doe',
            age: 35,
            lastUpdated: '2023-11-15'
        },
        {
            id: 'PT-1002',
            name: 'Jane Smith',
            age: 42,
            lastUpdated: '2023-11-14'
        }
    ];
    res.json(patients);
});

// Serve HTML files
app.get('*', (req, res) => {
    const filePath = path.join(__dirname, req.path === '/' ? 'index.html' : req.path);
    
    if (fs.existsSync(filePath)) {
        res.sendFile(filePath);
    } else {
        res.status(404).send('Page not found');
    }
});

app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
    console.log('Available routes:');
    console.log(`- Dashboard: http://localhost:${PORT}/index.html`);
    console.log(`- Login: http://localhost:${PORT}/login.html`);
    console.log(`- Create Patient: http://localhost:${PORT}/create.html`);
    console.log(`- View Patients: http://localhost:${PORT}/view.html`);
});