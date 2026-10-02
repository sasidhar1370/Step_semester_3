import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
abstract class LibraryItem {
    protected String title;
    protected static final LocalDate BASE_DATE = LocalDate.of(2023, 10, 26);
    public LibraryItem(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public abstract LocalDate calculateDueDate();
}
class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }
    public LocalDate calculateDueDate() {
        return BASE_DATE.plusDays(14);
    }
}
class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }
    public LocalDate calculateDueDate() {
        return BASE_DATE.plusDays(7);
    }
}
class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }
    public LocalDate calculateDueDate() {
        return BASE_DATE.plusDays(3);
    }
}
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"?([^\"]+)\"?$");
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String type = matcher.group(1);
                String title = matcher.group(2);
                switch (type) {
                    case "BOOK":
                        items.add(new Book(title));
                        break;
                    case "DVD":
                        items.add(new DVD(title));
                        break;
                    case "MAGAZINE":
                        items.add(new Magazine(title));
                        break;
                }
            }
        }
        for (LibraryItem item : items) {
            LocalDate dueDate = item.calculateDueDate();
            System.out.println(item.getTitle() + ": " + dueDate.format(formatter));
        }
        scanner.close();
    }
}