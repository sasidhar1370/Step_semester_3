import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Abstract base class ensures a plain "ticket" cannot be instantiated directly
abstract class Ticket {
    // Shared convenience fee defined in one place
    private static final double CONVENIENCE_FEE = 20.0;

    private String seatType;
    private int count;

    public Ticket(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() {
        return seatType;
    }

    public int getCount() {
        return count;
    }

    // Abstract method implemented by each specific seat type
    public abstract double getBasePrice();

    // Total cost calculation includes base price and convenience fee per ticket
    public double calculateTotal() {
        return count * (getBasePrice() + CONVENIENCE_FEE);
    }

    public void printReport() {
        System.out.printf("%s: %.2f\n", seatType, calculateTotal());
    }
}

// Regular seat implementation
class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super("REGULAR", count);
    }

    @Override
    public double getBasePrice() {
        return 150.0;
    }
}

// Premium seat implementation
class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super("PREMIUM", count);
    }

    @Override
    public double getBasePrice() {
        return 250.0;
    }
}

// Recliner seat implementation
class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super("RECLINER", count);
    }

    @Override
    public double getBasePrice() {
        return 400.0;
    }
}

public class Main1hw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Ticket> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seatType = scanner.next();
            int count = scanner.nextInt();

            switch (seatType) {
                case "REGULAR":
                    bookings.add(new RegularTicket(count));
                    break;
                case "PREMIUM":
                    bookings.add(new PremiumTicket(count));
                    break;
                case "RECLINER":
                    bookings.add(new ReclinerTicket(count));
                    break;
            }
        }

        double totalCollected = 0.0;

        for (Ticket ticket : bookings) {
            ticket.printReport();
            totalCollected += ticket.calculateTotal();
        }

        System.out.printf("Total: %.2f\n", totalCollected);

        scanner.close();
    }
}