import java.util.Scanner;
public class CsvStudentRecordParser {
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();
        System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter CSV Record (Name, RollNo, Department): ");
            String csvLine = scanner.nextLine();
            parseStudentRecord(csvLine);
        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}