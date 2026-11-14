import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TransactionDuplicateCheck {

    public static boolean hasDuplicate(List<String> transactionIds) {
        Set<String> seenIds = new HashSet<>();

        for (String id : transactionIds) {
            // HashSet.add() returns false if the element already exists in the set
            if (!seenIds.add(id)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of transactions: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline

        List<String> transactionIds = new ArrayList<>();
        System.out.println("Enter " + n + " transaction IDs (one per line):");
        for (int i = 0; i < n; i++) {
            transactionIds.add(scanner.nextLine().trim());
        }

        boolean result = hasDuplicate(transactionIds);
        System.out.println("Contains duplicates: " + result);

        scanner.close();
    }
}