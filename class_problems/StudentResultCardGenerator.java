import java.util.Scanner;
class Student {
    private String name;
    private int[] marks;
    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
    public double calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }
    public char calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 75) {
            return 'B';
        } else if (avg >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }
    public void printResultCard() {
        double avg = calculateAverage();
        char grade = calculateGrade();
        System.out.printf("%s: Average %.1f, Grade %c\n", name.toUpperCase(), avg, grade);
    }
}
public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String name = line.substring(0, line.indexOf('[')).trim();
            String arrayPart = line.substring(line.indexOf('[') + 1, line.indexOf(']'));
            String[] parts = arrayPart.split(",\\s*");
            int[] marks = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                marks[i] = Integer.parseInt(parts[i].trim());
            }
            Student student = new Student(name, marks);
            student.printResultCard();
        }
        scanner.close();
    }
}