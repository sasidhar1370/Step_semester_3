import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Abstract base class representing a general Plot
abstract class Plot {
    private String owner;
    private String shapeType;

    public Plot(String owner, String shapeType) {
        this.owner = owner;
        this.shapeType = shapeType;
    }

    public String getOwner() {
        return owner;
    }

    public String getShapeType() {
        return shapeType;
    }

    // Abstract method to be implemented by each specific shape
    public abstract double calculateArea();

    public void printReport() {
        System.out.printf("%s (%s): %.2f\n", owner, shapeType, calculateArea());
    }
}

// Circle plot implementation
class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Rectangle plot implementation
class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Triangle plot implementation
class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String shape = scanner.next();
            String owner = scanner.next();

            switch (shape) {
                case "CIRCLE":
                    double radius = scanner.nextDouble();
                    plots.add(new CirclePlot(owner, radius));
                    break;
                case "RECTANGLE":
                    double length = scanner.nextDouble();
                    double width = scanner.nextDouble();
                    plots.add(new RectanglePlot(owner, length, width));
                    break;
                case "TRIANGLE":
                    double base = scanner.nextDouble();
                    double height = scanner.nextDouble();
                    plots.add(new TrianglePlot(owner, base, height));
                    break;
            }
        }

        double totalArea = 0.0;

        // Print individual reports and aggregate total area
        for (Plot plot : plots) {
            plot.printReport();
            totalArea += plot.calculateArea();
        }

        System.out.printf("Total Area: %.2f\n", totalArea);

        scanner.close();
    }
}