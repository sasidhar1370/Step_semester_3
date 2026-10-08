import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Capability interface for students using college transport
interface BusUser {
    double TRANSPORT_FEE = 12000.0;
}

// Abstract base class representing a general Student
abstract class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method for tuition fee specific to each type
    public abstract double getTuition();

    // Total fee calculation checks for BusUser capability
    public double calculateTotalFee() {
        double total = getTuition();
        if (this instanceof BusUser) {
            total += BusUser.TRANSPORT_FEE;
        }
        return total;
    }

    public void printReport() {
        System.out.printf("%s: %.2f\n", name, calculateTotalFee());
    }
}

// Day scholar student (uses bus)
class DayScholar extends Student implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double getTuition() {
        return 40000.0;
    }
}

// Hosteller student (does NOT use bus)
class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double getTuition() {
        return 40000.0 + 60000.0; // Tuition + Hostel fee
    }
}

// Scholarship student (uses bus)
class Scholar extends Student implements BusUser {
    public Scholar(String name) {
        super(name);
    }

    @Override
    public double getTuition() {
        return 20000.0; // Half of normal tuition
    }
}

public class Main3hw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(name));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(name));
                    break;
                case "SCHOLAR":
                    students.add(new Scholar(name));
                    break;
            }
        }

        double totalCollected = 0.0;

        for (Student student : students) {
            student.printReport();
            totalCollected += student.calculateTotalFee();
        }

        System.out.printf("Total Collected: %.2f\n", totalCollected);

        scanner.close();
    }
}