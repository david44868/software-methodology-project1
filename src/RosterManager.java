import java.util.Scanner;
import java.util.StringTokenizer;

public class RosterManager {

    public RosterManager() {

    }

    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("Roster Manager running...");
        Roster roster = new Roster();

        String input = in.nextLine();
        while(!input.equals("Q")) {
            StringTokenizer st1 = new StringTokenizer(input, " ");
            String command = st1.nextToken();
            switch(command) {
                case "A":
                    roster.add(new Student(st1.nextToken(), st1.nextToken(), st1.nextToken(), st1.nextToken(), Integer.parseInt(st1.nextToken())));
                    break;
                case "R":
                    roster.remove();
                case "P":
                case "PS":
                case "PC":
                case "L":
                case "C":
                default:
                    System.out.println(command + "is an invalid command!");
                    break;
            }
            input = in.nextLine();
        }
        System.out.println("Roster Manager terminated.");
    }
}
