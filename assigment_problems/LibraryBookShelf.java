import java.util.Arrays;

public class LibraryBookShelf {

    public static void shelf(int[] books) {
        int n = books.length;

        // Start from the second book (index 1) onwards
        for (int i = 1; i < n; i++) {
            int newBook = books[i];
            int j = i - 1;

            // Shift every bigger book on the left one place to the right
            while (j >= 0 && books[j] > newBook) {
                books[j + 1] = books[j];
                j--;
            }

            // Place the new book into the gap
            books[j + 1] = newBook;

            System.out.println("After placing " + newBook + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        // Sample Input
        int[] books1 = {30, 10, 40, 20};
        System.out.println("Sample Input: " + Arrays.toString(books1));
        shelf(books1);

        // Custom Input
        int[] customBooks = {50, 25, 35, 15, 45};
        System.out.println("\nCustom Input: " + Arrays.toString(customBooks));
        shelf(customBooks);
    }
}