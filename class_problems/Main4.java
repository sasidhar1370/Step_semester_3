import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Abstract base class representing a connection
abstract class ElectricityConnection {
    private String type;
    private double units;

    public ElectricityConnection(String type, double units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public double getUnits() {
        return units;
    }

    // Abstract method to calculate bill based on business rules
    public abstract double calculateBill();

    public void printReport() {
        System.out.printf("%s: %.2f\n", type, calculateBill());
    }
}

// Home connection: 5 per unit for first 100 units, 7 per unit for remaining
class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        double units = getUnits();
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

// Shop connection: 8 per unit plus fixed charge of 100
class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (getUnits() * 8.0) + 100.0;
    }
}

// Factory connection: 6 per unit with a minimum bill of 1000
class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        double bill = getUnits() * 6.0;
        return Math.max(bill, 1000.0);
    }
}

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();

            switch (type) {
                case "HOME":
                    connections.add(new HomeConnection(units));
                    break;
                case "SHOP":
                    connections.add(new ShopConnection(units));
                    break;
                case "FACTORY":
                    connections.add(new FactoryConnection(units));
                    break;
            }
        }

        double totalBill = 0.0;

        for (ElectricityConnection connection : connections) {
            connection.printReport();
            totalBill += connection.calculateBill();
        }

        System.out.printf("Total: %.2f\n", totalBill);

        scanner.close();
    }
}