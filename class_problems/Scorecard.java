public class Scorecard {
    // Private array to store answer results internally
    private final boolean[] results;
    // Counter to track how many answers have been recorded so far
    private int recordedCount;

    // Constructor fixes the total number of questions when created
    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    // Records the answer result one at a time; rejects/ignores if total question count is exceeded
    public void recordAnswer(boolean isCorrect) {
        if (recordedCount < results.length) {
            results[recordedCount] = isCorrect;
            recordedCount++;
        }
    }

    // Reveals only the total score (count of true values)
    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    // Main method demonstrating sample input/output and behavior
    public static void main(String[] args) {
        // Create a scorecard for 4 questions
        Scorecard sc = new Scorecard(4);

        // Record answers: true, true, false, true
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        // Print final score (Expected: 3)
        System.out.println("Score: " + sc.getScore());

        // Attempting to add extra answers beyond the fixed question count (ignored)
        sc.recordAnswer(true);
        System.out.println("Score after extra answer: " + sc.getScore());
    }
}