class HallTicket {
    String studentName;
    int seatNumber;

    // Constructor to initialize fields
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

class ExamHall {
    public static void main(String[] args) {
        // Create initial object
        HallTicket priya = new HallTicket("Priya", 0);

        // Copy reference to the same memory object
        HallTicket copy = priya;

        // Modify state via second reference
        copy.seatNumber = 45;

        // Create a distinct object with identical initial values
        HallTicket separate = new HallTicket("Priya", 45);

        // Output results matching the expected assignment format
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}