import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class representing a subscription plan
abstract class Plan {
    protected String subscriberName;
    protected LocalDate startDate;

    public Plan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public abstract LocalDate calculateRenewalDate();
}

// Basic plan: valid for 30 days
class BasicPlan extends Plan {
    public BasicPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

// Standard plan: valid for 90 days
class StandardPlan extends Plan {
    public StandardPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

// Premium plan: valid for 365 days
class PremiumPlan extends Plan {
    public PremiumPlan(String subscriberName, LocalDate startDate) {
        super(subscriberName, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class Main5hw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Plan> subscribers = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String planType = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr, formatter);

            switch (planType) {
                case "BASIC":
                    subscribers.add(new BasicPlan(name, startDate));
                    break;
                case "STANDARD":
                    subscribers.add(new StandardPlan(name, startDate));
                    break;
                case "PREMIUM":
                    subscribers.add(new PremiumPlan(name, startDate));
                    break;
            }
        }

        // Polymorphic processing without explicit type checking in the loop
        for (Plan plan : subscribers) {
            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.println(plan.getSubscriberName() + ": " + renewalDate.format(formatter));
        }

        scanner.close();
    }
}