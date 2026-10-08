import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Abstract base class for library items
abstract class LibraryItem {
    private String title;
    private int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public int getDaysLate() {
        return daysLate;
    }

    // Abstract method to calculate fine based on item rules
    public abstract double calculateFine();

    public void printReport() {
        System.out.printf("%s: %.2f\n", title, calculateFine());
    }
}

// Book implementation: 2 per day late
class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return getDaysLate() * 2.0;
    }
}

// DVD implementation: 5 per day late, max 50
class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        double fine = getDaysLate() * 5.0;
        return Math.min(fine, 50.0);
    }
}

// Magazine implementation: 1 per day late
class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return getDaysLate() * 1.0;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();

            switch (type) {
                case "BOOK":
                    items.add(new Book(title, daysLate));
                    break;
                case "DVD":
                    items.add(new DVD(title, daysLate));
                    break;
                case "MAGAZINE":
                    items.add(new Magazine(title, daysLate));
                    break;
            }
        }

        double totalFines = 0.0;

        for (LibraryItem item : items) {
            item.printReport();
            totalFines += item.calculateFine();
        }

        System.out.printf("Total Fines: %.2f\n", totalFines);

        scanner.close();
    }
}