import java.util.Scanner;
public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "Rejected — invalid file type";
        }
        int lastDotIndex = filename.lastIndexOf('.');
        String extension = filename.substring(lastDotIndex + 1).toLowerCase();
        if (extension.equals("pdf") || extension.equals("docx") || extension.equals("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter filename: ");
            String filename = scanner.nextLine();
            String result = validateFileExtension(filename);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}