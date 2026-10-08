import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Capability interface for insurable parcels
interface Insurable {
    double calculateInsurance();
}

// Abstract base class for all parcels
abstract class Parcel {
    private String type;
    private double weightKg;
    private double declaredValue;

    public Parcel(String type, double weightKg, double declaredValue) {
        this.type = type;
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public String getType() {
        return type;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public double getDeclaredValue() {
        return declaredValue;
    }

    // Abstract method to calculate base shipping charge
    public abstract double calculateCharge();

    // Calculate insurance cost (0.0 if not insurable)
    public double getInsuranceCost() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance();
        }
        return 0.0;
    }

    // Total cost = base charge + insurance
    public double calculateTotal() {
        return calculateCharge() + getInsuranceCost();
    }

    public void printReport() {
        System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n",
                type, calculateCharge(), getInsuranceCost(), calculateTotal());
    }
}

// Standard parcel: 40 + 10 per kg (not insurable)
class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super("STANDARD", weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * getWeightKg());
    }
}

// Express parcel: 80 + 15 per kg (insurable)
class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super("EXPRESS", weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * getWeightKg());
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * getDeclaredValue();
    }
}

// Fragile parcel: standard charge + 50 handling fee (insurable)
class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super("FRAGILE", weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        double standardCharge = 40.0 + (10.0 * getWeightKg());
        return standardCharge + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * getDeclaredValue();
    }
}

public class Main2hw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weightKg = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            switch (type) {
                case "STANDARD":
                    parcels.add(new StandardParcel(weightKg, declaredValue));
                    break;
                case "EXPRESS":
                    parcels.add(new ExpressParcel(weightKg, declaredValue));
                    break;
                case "FRAGILE":
                    parcels.add(new FragileParcel(weightKg, declaredValue));
                    break;
            }
        }

        double grandTotal = 0.0;

        for (Parcel parcel : parcels) {
            parcel.printReport();
            grandTotal += parcel.calculateTotal();
        }

        System.out.printf("Grand Total: %.2f\n", grandTotal);

        scanner.close();
    }
}