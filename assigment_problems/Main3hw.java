import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a hostel room
abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getRoomType();
}

// Single Room: ₹8 per unit
class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }

    @Override
    public String getRoomType() {
        return "SINGLE";
    }
}

// Shared Room: ₹6 per unit, divided equally by the number of occupants
class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }

    @Override
    public String getRoomType() {
        return "SHARED";
    }
}

// AC Room: ₹10 per unit, plus a fixed charge of ₹200
class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }

    @Override
    public String getRoomType() {
        return "AC";
    }
}

public class Main3hw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();

            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoom(units));
                    break;
                case "SHARED":
                    int occupants = scanner.nextInt();
                    rooms.add(new SharedRoom(units, occupants));
                    break;
                case "AC":
                    rooms.add(new ACRoom(units));
                    break;
            }
        }

        double grandTotal = 0.0;

        // Polymorphic loop processing each room without checking its type
        for (Room room : rooms) {
            double bill = room.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f%n", room.getRoomType(), bill);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}