import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;
    private double compositeScore;
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        this.compositeScore = (cgpa * 10) + codingScore;
    }
    public double getCgpa() { return cgpa; }
    public int getCodingScore() { return codingScore; }
    public String getName() { return name; }
    public double getCompositeScore() { return compositeScore; }
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }
    public static boolean isEligible(double cgpa, int codingScore) {
        return (cgpa >= 6.5 && codingScore >= 60);
    }
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore, this.compositeScore);
    }
}
public class PlacementEngine {
    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null) return "";
        List<Candidate> shortlisted = new ArrayList<>();
        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.getCgpa()) || Candidate.isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted.add(c);
            }
        }
        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            Candidate c = shortlistedArray[i];
            sb.append(i + 1).append(". ").append(c.getName())
                    .append(" (").append(c.getCompositeScore()).append(")");
            if (i < shortlistedArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of candidates: ");
        int n = scanner.nextInt();
        Candidate[] candidates = new Candidate[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nCandidate " + (i + 1) + " Details:");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("CGPA: ");
            double cgpa = scanner.nextDouble();
            System.out.print("Coding Score: ");
            int codingScore = scanner.nextInt();
            candidates[i] = new Candidate(name, cgpa, codingScore);
        }
        System.out.println("\n--- Shortlisted & Ranked Leaderboard ---");
        System.out.println(shortlistAndRank(candidates));
        scanner.close();
    }
}