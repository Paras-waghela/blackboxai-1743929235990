# Hospital File Management System

## Project Overview
The Hospital File Management System (MediFile) is a Java-based application with a web interface designed for secure patient record management. It uses RMI and Socket programming for backend operations and features a modern HTML/CSS frontend.

## Key Features
- **Patient Record Management**:
  - Create new patient records
  - View and search existing records
  - Download patient files
- **Advanced Search**:
  - Search by patient name, diagnosis, or other criteria
- **Data Security**:
  - Secure file storage
  - Encoded data transmission
- **Modern UI**:
  - Responsive design with Tailwind CSS
  - Intuitive user interface

## System Architecture
- **Backend**:
  - Java RMI for remote operations
  - Socket server for real-time communication
  - File-based data storage
- **Frontend**:
  - HTML5/CSS3 interface
  - JavaScript for client-side operations
  - Tailwind CSS for styling

## Installation
1. **Requirements**:
   - Java 8+
   - Python 3 (for web server)

2. **Setup**:
```bash
# Clone repository
git clone https://github.com/your-repo/hospital-management.git

# Make run script executable
chmod +x run.sh
```

## Running the System
```bash
# Start the system
./run.sh
```

This will:
- Start RMI registry (port 1099)
- Launch Java server (port 8000)
- Serve web interface (port 9000)

## Usage
Access the web interface at: `http://localhost:9000/PatientForm.html`

- **Create Records**: Fill the patient form and submit
- **View Records**: Click "View All" to see all patients
- **Search**: Use the search button to find specific records
- **Download**: Click download button to save patient files

## Project Structure
```
hospital-management/
├── java/
│   ├── HospitalServer.java       # Main server
│   ├── PatientFileManager.java   # RMI interface
│   ├── PatientFileManagerImpl.java # RMI implementation
│   ├── HospitalClient.java       # Test client
│   ├── Patient.java              # Data model
│   └── FileUtils.java            # File operations
├── web/
│   ├── PatientForm.html          # Main interface
│   ├── view.html                 # View records
│   └── download.html             # Download page
├── run.sh                        # Startup script
└── README.md                     # Documentation
```

## Dependencies
- Java Standard Library
- Python 3 (for web server)
- Tailwind CSS (CDN)

## Support
For any issues, please contact: support@example.com

## License
MIT License