import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

public class PatientFileManagerImpl extends UnicastRemoteObject implements PatientFileManager {
    public PatientFileManagerImpl() throws RemoteException {}

    public void createPatientFile(String data) throws RemoteException {
        try {
            String filename = "patient_" + System.currentTimeMillis() + ".txt";
            FileUtils.saveToFile(filename, data);
        } catch (IOException e) {
            throw new RemoteException("File creation failed", e);
        }
    }

    public byte[] downloadFile(String filename) throws RemoteException {
        try {
            return FileUtils.readFromFile(filename).getBytes();
        } catch (IOException e) {
            throw new RemoteException("Download failed", e);
        }
    }

    public String[] listFiles() throws RemoteException {
        try {
            return FileUtils.listFiles();
        } catch (IOException e) {
            throw new RemoteException("File listing failed", e);
        }
    }
}