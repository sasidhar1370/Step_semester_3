public class NameTag {
    // Private and final fields to ensure immutability
    private final String firstName;
    private final String lastNameInitial;

    // Constructor splits the full name string once and initializes final fields
    public NameTag(String fullName) {
        String[] nameParts = fullName.split(" ");
        this.firstName = nameParts[0];
        // Take the first character of the last name and format as initial (e.g., "G.")
        this.lastNameInitial = nameParts[1].charAt(0) + ".";
    }

    // Returns the formatted nickname (e.g., "Maria G.")
    public String getNickname() {
        return firstName + " " + lastNameInitial;
    }

    // Main method demonstrating sample usage
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");

        // Output: Maria G.
        System.out.println("Nickname: " + tag.getNickname());
    }
}