import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;
    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }
    public abstract double evaluateScore();
    public abstract String getType();
}
class MCQQuestion extends Question {
    public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }
    public double evaluateScore() {
        if (studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            return points;
        }
        return 0.0;
    }
    public String getType() {
        return "MCQ";
    }
}
class TFQuestion extends Question {
    public TFQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }
    public double evaluateScore() {
        if (studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            return points;
        }
        return 0.0;
    }
    public String getType() {
        return "TF";
    }
}
class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }
    public double evaluateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerStudentAns = studentAnswer.toLowerCase();
        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && lowerStudentAns.contains(trimmedKw)) {
                matchCount++;
            }
        }
        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }
    public String getType() {
        return "ESSAY";
    }
}
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+(?:\\.\\d+)?)$");
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String type = matcher.group(1);
                String qText = matcher.group(2);
                String correctAns = matcher.group(3);
                String studentAns = matcher.group(4);
                double pts = Double.parseDouble(matcher.group(5));
                switch (type) {
                    case "MCQ":
                        questions.add(new MCQQuestion(qText, correctAns, studentAns, pts));
                        break;
                    case "TF":
                        questions.add(new TFQuestion(qText, correctAns, studentAns, pts));
                        break;
                    case "ESSAY":
                        questions.add(new EssayQuestion(qText, correctAns, studentAns, pts));
                        break;
                }
            }
        }
        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.evaluateScore();
            totalScore += score;
            System.out.printf("%s: %.2f%n", q.getType(), score);
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
        scanner.close();
    }
}