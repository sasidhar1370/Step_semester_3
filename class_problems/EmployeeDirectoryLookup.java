import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeDirectoryLookup {

    // Helper class to represent an initial employee record pair
    public static class EmployeeRecord {
        String employeeId;
        String department;

        public EmployeeRecord(String employeeId, String department) {
            this.employeeId = employeeId;
            this.department = department;
        }
    }

    public static Map<String, String> buildLookup(List<EmployeeRecord> records) {
        Map<String, String> lookup = new HashMap<>();
        for (EmployeeRecord record : records) {
            lookup.put(record.employeeId, record.department);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employee records: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<EmployeeRecord> records = new ArrayList<>();
        System.out.println("Enter each record as 'employeeId department' (e.g., E245 Finance):");
        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            String dept = scanner.next();
            records.add(new EmployeeRecord(id, dept));
        }

        // Pre-process records into a HashMap for fast lookups
        Map<String, String> lookup = buildLookup(records);

        System.out.print("Enter the number of queries: ");
        int q = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < q; i++) {
            System.out.print("Enter Employee ID to look up: ");
            String targetId = scanner.nextLine().trim();
            System.out.println("Department: " + getDepartment(lookup, targetId));
        }

        scanner.close();
    }
}