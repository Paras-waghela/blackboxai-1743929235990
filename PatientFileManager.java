import java.rmi.*;

public interface PatientFileManager extends Remote {
    void createPatientFile(String data) throws RemoteException;
    byte[] downloadFile(String filename) throws RemoteException;
    String[] listFiles() throws RemoteException;
}