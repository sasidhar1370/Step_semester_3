public class Locker {
    // Final field for fixed locker number
    private final int lockerNumber;
    // Private field with no getter to store the combination code
    private String combinationCode;

    // Constructor initializes locker number and initial combination code
    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    // Changes the combination code only if the current code matches
    public boolean changeCode(String currentCode, String newCode) {
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            return true; // Code updated successfully
        }
        return false; // Rejected due to incorrect current code
    }

    // Getter for locker number (fixed at creation)
    public int getLockerNumber() {
        return lockerNumber;
    }

    // Main method demonstrating sample usage
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        // Attempting to change code with correct current code
        boolean success1 = l.changeCode("1234", "5678");
        System.out.println("Change ('1234' -> '5678'): " + (success1 ? "success" : "rejected"));

        // Attempting to change code with wrong current code
        boolean success2 = l.changeCode("0000", "9999");
        System.out.println("Change ('0000' -> '9999'): " + (success2 ? "success" : "rejected"));
    }
}