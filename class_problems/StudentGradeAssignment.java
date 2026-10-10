import java.util.Scanner;
public class StudentGradeAssignment {
    public static void printGrade(int mark) {
        if (mark >= 90) {
            System.out.println("Grade A");
        } else if (mark >= 75) {
            System.out.println("Grade B");
        } else if (mark >= 60) {
            System.out.println("Grade C");
        } else if (mark >= 40) {
            System.out.println("Grade D");
        } else {
            System.out.println("Grade F");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int mark = scanner.nextInt();
            printGrade(mark);
        }
        scanner.close();
    }
}