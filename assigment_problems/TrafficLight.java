public class TrafficLight {
    // Final ID fixed upon object creation
    private final String id;
    // Private field for current color with no setter
    private String color;

    // Constructor sets the fixed ID and initializes the light to "RED"
    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    // Cycles the color strictly through: RED -> GREEN -> YELLOW -> RED
    public void next() {
        switch (this.color) {
            case "RED":
                this.color = "GREEN";
                break;
            case "GREEN":
                this.color = "YELLOW";
                break;
            case "YELLOW":
                this.color = "RED";
                break;
        }
    }

    // Read-only getter for current color
    public String getColor() {
        return this.color;
    }

    // Read-only getter for traffic light ID
    public String getId() {
        return this.id;
    }

    // Main method demonstrating sample usage and behavior
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println("Initial color: " + t.getColor()); // Output: RED

        t.next();
        System.out.println("After 1st next(): " + t.getColor()); // Output: GREEN

        t.next();
        System.out.println("After 2nd next(): " + t.getColor()); // Output: YELLOW

        t.next();
        System.out.println("After 3rd next(): " + t.getColor()); // Output: RED
    }
}