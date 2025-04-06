import java.rmi.*;
import java.io.*;
import java.net.*;

public class HospitalClient {
    public static void main(String[] args) {
        try {
            // Connect to RMI server
            System.out.println("Connecting to RMI server...");
            PatientFileManager service = (PatientFileManager)Naming.lookup("rmi://localhost/PatientService");
            
            // Test creating a patient file
            System.out.println("\nCreating sample patient file...");
            String patientData = "Name: John Doe\nAge: 35\nDiagnosis: Hypertension\n";
            service.createPatientFile(patientData);
            
            // List available files
            System.out.println("\nAvailable patient files:");
            String[] files = service.listFiles();
            for (String file : files) {
                System.out.println("- " + file);
            }
            
            // Download and display a file
            if (files.length > 0) {
                System.out.println("\nDownloading first file...");
                byte[] fileContent = service.downloadFile(files[0]);
                System.out.println("\nFile content:\n" + new String(fileContent));
            }
            
            System.out.println("\nClient operations completed successfully!");
            
        } catch (Exception e) {
            System.err.println("Client error:");
            e.printStackTrace();
        }
    }
}