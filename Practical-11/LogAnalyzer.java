import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class LogAnalyzer {

    public static void main(String[] args) {

        Path folder = Paths.get("logs");

        try {
            // Create logs folder
            Files.createDirectories(folder);

            // Create sample text files
            Path file1 = folder.resolve("app1.txt");
            Path file2 = folder.resolve("app2.txt");
            Path file3 = folder.resolve("app3.txt");

            Files.write(file1, List.of(
                    "Application started",
                    "User login successful",
                    "ERROR: Database connection failed",
                    "Application closed"));

            Files.write(file2, List.of(
                    "Server started",
                    "ERROR: File not found",
                    "User logged in",
                    "Server stopped"));

            Files.write(file3, List.of(
                    "Login successful",
                    "Data saved",
                    "ERROR: Invalid input",
                    "Application restarted"));

            String keyword = "ERROR";

            int totalLines = 0;
            int keywordCount = 0;

            // Read all text files from logs folder
            try (DirectoryStream<Path> files = Files.newDirectoryStream(folder, "*.txt")) {

                for (Path file : files) {

                    System.out.println("\nFile: " + file.getFileName());

                    // Get file size using attributes
                    BasicFileAttributes attributes = Files.readAttributes(
                            file,
                            BasicFileAttributes.class);

                    System.out.println(
                            "Size: " + attributes.size() + " bytes");

                    // Read file line by line
                    List<String> lines = Files.readAllLines(file);

                    for (String line : lines) {

                        totalLines++;

                        if (line.contains(keyword)) {
                            keywordCount++;
                        }
                    }
                }
            }

            // Display final result
            System.out.println("\n==========================");
            System.out.println("Total Lines     : " + totalLines);
            System.out.println(
                    "Lines with " + keyword + " : " + keywordCount);
            System.out.println("==========================");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}