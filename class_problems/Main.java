import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
abstract class PaymentMethod {
    protected double amount;
    public PaymentMethod(double amount) {
        this.amount = amount;
    }
    public abstract double calculateAdjustedAmount();
    public abstract String getType();
}
class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super(amount);
    }
    public double calculateAdjustedAmount() {
        return amount * 1.02;
    }
    public String getType() {
        return "CARD";
    }
}
class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super(amount);
    }
    public double calculateAdjustedAmount() {
        return amount * 1.01;
    }
    public String getType() {
        return "WALLET";
    }
}
class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super(amount);
    }
    public double calculateAdjustedAmount() {
        return amount;
    }
    public String getType() {
        return "BANKTRANSFER";
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<PaymentMethod> transactions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            switch (type) {
                case "CARD":
                    transactions.add(new CardPayment(amount));
                    break;
                case "WALLET":
                    transactions.add(new WalletPayment(amount));
                    break;
                case "BANKTRANSFER":
                    transactions.add(new BankTransferPayment(amount));
                    break;
            }
        }
        double grandTotal = 0.0;
        for (PaymentMethod payment : transactions) {
            double adjustedAmount = payment.calculateAdjustedAmount();
            grandTotal += adjustedAmount;
            System.out.printf("%s: %.2f%n", payment.getType(), adjustedAmount);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}