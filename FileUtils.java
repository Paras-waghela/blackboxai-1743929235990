import java.io.*;
import java.nio.file.*;

public class FileUtils {
    public static void saveToFile(String filename, String content) throws IOException {
        Path path = Paths.get("patient_files", filename);
        Files.createDirectories(path.getParent());
        Files.write(path, content.getBytes());
    }

    public static String readFromFile(String filename) throws IOException {
        Path path = Paths.get("patient_files", filename);
        return new String(Files.readAllBytes(path));
    }

    public static String[] listFiles() throws IOException {
        Path dir = Paths.get("patient_files");
        if (!Files.exists(dir)) {
            return new String[0];
        }
        return Files.list(dir)
                   .map(Path::getFileName)
                   .map(Path::toString)
                   .toArray(String[]::new);
    }
}