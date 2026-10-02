import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
abstract class CustomerBill {
    protected double amount;
    public CustomerBill(double amount) {
        this.amount = amount;
    }
    public abstract double calculateFinalAmount();
    public abstract String getCustomerType();
}
class StudentBill extends CustomerBill {
    public StudentBill(double amount) {
        super(amount);
    }
    public double calculateFinalAmount() {
        return amount * 0.90;
    }
    public String getCustomerType() {
        return "STUDENT";
    }
}
class StaffBill extends CustomerBill {
    public StaffBill(double amount) {
        super(amount);
    }
    public double calculateFinalAmount() {
        return amount * 0.95;
    }
    public String getCustomerType() {
        return "STAFF";
    }
}
class GuestBill extends CustomerBill {
    public GuestBill(double amount) {
        super(amount);
    }
    public double calculateFinalAmount() {
        return amount + 10.0;
    }
    public String getCustomerType() {
        return "GUEST";
    }
}
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<CustomerBill> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            switch (type) {
                case "STUDENT":
                    bills.add(new StudentBill(amount));
                    break;
                case "STAFF":
                    bills.add(new StaffBill(amount));
                    break;
                case "GUEST":
                    bills.add(new GuestBill(amount));
                    break;
            }
        }
        double totalAmount = 0.0;
        for (CustomerBill bill : bills) {
            double finalAmount = bill.calculateFinalAmount();
            totalAmount += finalAmount;
            System.out.printf("%s: %.2f%n", bill.getCustomerType(), finalAmount);
        }
        System.out.printf("Total: %.2f%n", totalAmount);
        scanner.close();
    }
}