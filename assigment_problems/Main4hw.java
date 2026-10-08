import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Capability interface for cabs that offer night service
interface NightService {
}

// Abstract base class representing a generic Cab
abstract class Cab {
    private String type;
    private double km;
    private String time;

    public Cab(String type, double km, String time) {
        this.type = type;
        this.km = km;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public double getKm() {
        return km;
    }

    public String getTime() {
        return time;
    }

    // Abstract method to get rate per km
    public abstract double getRate();

    // Check if trip is rejected
    public boolean isRejected() {
        return "NIGHT".equalsIgnoreCase(time) && !(this instanceof NightService);
    }

    // Calculate fare with minimum fee and night charge rules
    public double calculateFare() {
        double baseFare = km * getRate();
        double fare = Math.max(baseFare, 100.0);

        if ("NIGHT".equalsIgnoreCase(time) && (this instanceof NightService)) {
            fare *= 1.20; // 20% surcharge
        }

        return fare;
    }
}

// Mini cab (does NOT offer night service)
class MiniCab extends Cab {
    public MiniCab(double km, String time) {
        super("MINI", km, time);
    }

    @Override
    public double getRate() {
        return 10.0;
    }
}

// Sedan cab (offers night service)
class SedanCab extends Cab implements NightService {
    public SedanCab(double km, String time) {
        super("SEDAN", km, time);
    }

    @Override
    public double getRate() {
        return 14.0;
    }
}

// SUV cab (offers night service)
class SUVCab extends Cab implements NightService {
    public SUVCab(double km, String time) {
        super("SUV", km, time);
    }

    @Override
    public double getRate() {
        return 18.0;
    }
}

public class Main4hw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Cab> trips = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            switch (cabType) {
                case "MINI":
                    trips.add(new MiniCab(km, time));
                    break;
                case "SEDAN":
                    trips.add(new SedanCab(km, time));
                    break;
                case "SUV":
                    trips.add(new SUVCab(km, time));
                    break;
            }
        }

        double totalFare = 0.0;

        for (Cab cab : trips) {
            if (cab.isRejected()) {
                System.out.printf("%s: night service not available\n", cab.getType());
            } else {
                double fare = cab.calculateFare();
                System.out.printf("%s: %.2f\n", cab.getType(), fare);
                totalFare += fare;
            }
        }

        System.out.printf("Total: %.2f\n", totalFare);

        scanner.close();
    }
}