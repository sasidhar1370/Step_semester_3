import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Abstract base class managing the shared booking fee
abstract class TravelBooking {
    // Shared booking fee defined in one place
    private static final double BOOKING_FEE = 50.0;

    private String mode;
    private double distanceKm;

    public TravelBooking(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    public String getMode() {
        return mode;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    // Abstract method for mode-specific base fare calculation
    public abstract double calculateBaseFare();

    // Final total fare adds the common booking fee to the base fare
    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    public void printReport() {
        System.out.printf("%s: %.2f\n", mode, calculateTotalFare());
    }
}

// Bus booking implementation: 2 per km
class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super("BUS", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return getDistanceKm() * 2.0;
    }
}

// Train booking implementation: 1.5 per km
class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return getDistanceKm() * 1.5;
    }
}

// Flight booking implementation: 2500 + 4 per km
class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (getDistanceKm() * 4.0);
    }
}

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings.add(new BusBooking(distance));
                    break;
                case "TRAIN":
                    bookings.add(new TrainBooking(distance));
                    break;
                case "FLIGHT":
                    bookings.add(new FlightBooking(distance));
                    break;
            }
        }

        for (TravelBooking booking : bookings) {
            booking.printReport();
        }

        scanner.close();
    }
}