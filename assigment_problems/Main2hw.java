import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
abstract class Vehicle {
    protected int hours;
    public Vehicle(int hours) {
        this.hours = hours;
    }
    public abstract double calculateCharge();
    public abstract String getVehicleType();
}
class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }
    public double calculateCharge() {
        return hours * 10.0;
    }
    public String getVehicleType() {
        return "BIKE";
    }
}
class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }
    public double calculateCharge() {
        if (hours <= 1) {
            return 30.0;
        }
        return 30.0 + (hours - 1) * 20.0;
    }
    public String getVehicleType() {
        return "CAR";
    }
}
class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }
    public double calculateCharge() {
        double charge = hours * 50.0;
        return Math.max(charge, 100.0);
    }
    public String getVehicleType() {
        return "TRUCK";
    }
}
public class Main2hw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            switch (type) {
                case "BIKE":
                    vehicles.add(new Bike(hours));
                    break;
                case "CAR":
                    vehicles.add(new Car(hours));
                    break;
                case "TRUCK":
                    vehicles.add(new Truck(hours));
                    break;
            }
        }
        double totalCharge = 0.0;
        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();
            totalCharge += charge;
            System.out.printf("%s: %.2f%n", vehicle.getVehicleType(), charge);
        }
        System.out.printf("Total: %.2f%n", totalCharge);
        scanner.close();
    }
}