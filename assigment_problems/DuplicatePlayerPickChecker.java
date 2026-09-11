import java.util.Scanner;
public class DuplicatePlayerPickChecker {
    static String findDuplicatePick(String[] playerNames){
        for (int i = 0; i < playerNames.length; i++){
            for (int j = i + 1; j < playerNames.length; j++){
                if(playerNames[i].equals(playerNames[j])){
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no.of Players: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] players = new String[n];
        System.out.print("Enter Players names: ");
        for (int i = 0; i < n; i++){
            players[i] = sc.nextLine();
        }
        String result = findDuplicatePick(players);
        System.out.println(result);
        sc.close();
    }
}
