import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }
    public abstract double calculateFare();
    public abstract String getType();
}
class BusTransport extends Transport {
    public BusTransport(double distance) {
        super(distance);
    }
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0); // Capped at Max Fare $10
    }
    public String getType() {
        return "BUS";
    }
}
class TrainTransport extends Transport {
    public TrainTransport(double distance) {
        super(distance);
    }
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
    public String getType() {
        return "TRAIN";
    }
}
class MetroTransport extends Transport {
    private double peakHourFactor;
    public MetroTransport(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
    public String getType() {
        return "METRO";
    }
}
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Transport> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            switch (type) {
                case "BUS":
                    journeys.add(new BusTransport(distance));
                    break;
                case "TRAIN":
                    journeys.add(new TrainTransport(distance));
                    break;
                case "METRO":
                    double peakHourFactor = scanner.nextDouble();
                    journeys.add(new MetroTransport(distance, peakHourFactor));
                    break;
            }
        }
        double grandTotalFare = 0.0;
        for (Transport journey : journeys) {
            double fare = journey.calculateFare();
            grandTotalFare += fare;
            System.out.printf("%s: %.2f%n", journey.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", grandTotalFare);
        scanner.close();
    }
}