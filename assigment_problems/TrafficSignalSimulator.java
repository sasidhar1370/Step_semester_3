import java.util.Scanner;

public class TrafficSignalSimulator {
    public static void simulateTrafficSignal(int cycles) {
        int state = 0; // 0 = Red, 1 = Green, 2 = Yellow
        for (int i = 0; i < cycles; i++) {
            switch (state % 3) {
                case 0:
                    System.out.print("Red - Stop ");
                    break;
                case 1:
                    System.out.print("Green - Go ");
                    break;
                case 2:
                    System.out.print("Yellow - Prepare to stop ");
                    break;
            }
            state = (state + 1) % 3;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of cycles to simulate: ");
        int cycles = scanner.nextInt();
        simulateTrafficSignal(cycles);
        scanner.close();
    }
}