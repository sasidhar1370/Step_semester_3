class BookInventory {
    String title;
    String author;
    int copiesAvailable;
    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }
    public void printEntry() {
        System.out.println(this.title + " by " + this.author + " - " + this.copiesAvailable + " copies available");
    }
}

class LibraryInventory {
    public static void main(String[] args) {
        // Create an array of BookInventory objects
        BookInventory[] inventory = {
                new BookInventory("Clean Code", "Robert C. Martin", 3),
                new BookInventory("Effective Java", "Joshua Bloch", 5),
                new BookInventory("Refactoring", "Martin Fowler", 0),
                new BookInventory("Design Patterns", "GoF", 2)
        };
        for (int i = 0; i < 4; i++) {
            inventory[i].printEntry();
        }
    }
}