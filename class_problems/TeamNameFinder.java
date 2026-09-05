import java.util.Scanner;
public class TeamNameFinder {
    public static String findDuplicateTeam(String[] teamNames){
        for (int i = 0; i < teamNames.length; i++){
            for (int j = 0; j < teamNames.length; j++){
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no.of Teams: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Team Names: ");
        String[] teamNames = new String[n];
        for (int i = 0; i < n; i++){
            teamNames[i] = sc.nextLine();
        }
        System.out.println(findDuplicateTeam(teamNames));
        sc.close();
    }
}
