import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Capability interface for appliances that support saver mode
interface SaverModeCapable {
}

// Abstract base class representing a general Appliance
abstract class Appliance {
    private String name;
    private double hours;
    private boolean isSaverRequested;

    public Appliance(String name, double hours, boolean isSaverRequested) {
        this.name = name;
        this.hours = hours;
        this.isSaverRequested = isSaverRequested;
    }

    public String getName() {
        return name;
    }

    public double getHours() {
        return hours;
    }

    public boolean isSaverRequested() {
        return isSaverRequested;
    }

    // Abstract method to get power rating in Watts
    public abstract double getPowerWatts();

    // Check if the appliance supports saver mode when requested
    public boolean isSaverSupported() {
        if (isSaverRequested) {
            return this instanceof SaverModeCapable;
        }
        return true; // If saver mode is not requested, request is valid
    }

    // Calculate energy units in kWh
    public double calculateUnits() {
        double units = (getPowerWatts() * hours) / 1000.0;
        if (isSaverRequested && (this instanceof SaverModeCapable)) {
            units *= 0.75; // 25% reduction in energy use
        }
        return units;
    }

    // Calculate energy cost at 8 per unit
    public double calculateCost() {
        return calculateUnits() * 8.0;
    }
}

// Fridge: 150 W (Does not support saver mode)
class Fridge extends Appliance {
    public Fridge(double hours, boolean isSaverRequested) {
        super("FRIDGE", hours, isSaverRequested);
    }

    @Override
    public double getPowerWatts() {
        return 150.0;
    }
}

// Air Conditioner: 1500 W (Supports saver mode)
class AirConditioner extends Appliance implements SaverModeCapable {
    public AirConditioner(double hours, boolean isSaverRequested) {
        super("AC", hours, isSaverRequested);
    }

    @Override
    public double getPowerWatts() {
        return 1500.0;
    }
}

// TV: 100 W (Does not support saver mode)
class TV extends Appliance {
    public TV(double hours, boolean isSaverRequested) {
        super("TV", hours, isSaverRequested);
    }

    @Override
    public double getPowerWatts() {
        return 100.0;
    }
}

// Washing Machine: 500 W (Supports saver mode)
class WashingMachine extends Appliance implements SaverModeCapable {
    public WashingMachine(double hours, boolean isSaverRequested) {
        super("WASHER", hours, isSaverRequested);
    }

    @Override
    public double getPowerWatts() {
        return 500.0;
    }
}

public class Main5hw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Appliance> appliances = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            double hours = scanner.nextDouble();

            boolean isSaverRequested = false;
            // Check if SAVER parameter is provided on the line
            if (scanner.hasNext("SAVER")) {
                scanner.next(); // consume "SAVER"
                isSaverRequested = true;
            }

            switch (name) {
                case "FRIDGE":
                    appliances.add(new Fridge(hours, isSaverRequested));
                    break;
                case "AC":
                    appliances.add(new AirConditioner(hours, isSaverRequested));
                    break;
                case "TV":
                    appliances.add(new TV(hours, isSaverRequested));
                    break;
                case "WASHER":
                    appliances.add(new WashingMachine(hours, isSaverRequested));
                    break;
            }
        }

        double totalCost = 0.0;

        for (Appliance appliance : appliances) {
            if (!appliance.isSaverSupported()) {
                System.out.printf("%s: saver mode not supported\n", appliance.getName());
            } else {
                double units = appliance.calculateUnits();
                double cost = appliance.calculateCost();
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", appliance.getName(), units, cost);
                totalCost += cost;
            }
        }

        System.out.printf("Total Cost: %.2f\n", totalCost);

        scanner.close();
    }
}