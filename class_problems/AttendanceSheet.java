public class AttendanceSheet {
    // Private array to store student names internally
    private final String[] presentStudents;
    // Counter to track the number of present students
    private int count;

    // Constructor sets maximum capacity for the class
    public AttendanceSheet(int maxCapacity) {
        this.presentStudents = new String[maxCapacity];
        this.count = 0;
    }

    // Marks a student present, preventing duplicate entries and capacity overflow
    public void markPresent(String studentName) {
        // Avoid adding duplicates or exceeding array bounds
        if (!isPresent(studentName) && count < presentStudents.length) {
            presentStudents[count] = studentName;
            count++;
        }
    }

    // Checks if a specific student is present
    public boolean isPresent(String studentName) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(studentName)) {
                return true;
            }
        }
        return false;
    }

    // Returns the total number of unique present students
    public int getPresentCount() {
        return count;
    }

    // Main method demonstrating sample usage
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        // Mark attendance (including duplicate entry for "Ana")
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        // Expected output: 2
        System.out.println("Present Count: " + sheet.getPresentCount());

        // Expected output: true
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));

        // Expected output: false
        System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
    }
}