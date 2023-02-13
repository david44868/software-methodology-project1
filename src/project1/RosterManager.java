package project1;

import project1.Student;

import java.util.Scanner;
import java.util.StringTokenizer;

public class RosterManager {

    public RosterManager() {

    }

    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("project1.Roster Manager running...");
        Roster roster = new Roster();
        String input = in.nextLine();
        while(!input.equals("Q")) {
            StringTokenizer st1 = new StringTokenizer(input, " ");
            String command = st1.nextToken();
            switch(command) {
                case "A":
                    if(roster.add(new Student(st1.nextToken(), st1.nextToken(), st1.nextToken(), st1.nextToken(), Integer.parseInt(st1.nextToken()))) {
                        System.out.println();
                    }
                    break;
                case "R":
                    roster.remove(new Student(st1.nextToken(), st1.nextToken(), st1.nextToken()));
                case "P":
                    roster.print();
                    break;
                case "PS":
                    roster.printByStanding();
                    break;
                case "PC":
                    roster.printBySchoolMajor();
                    break;
                case "L":
                    break;
                case "C":
                    break;
                default:
                    System.out.println(command + "is an invalid command!");
                    break;
            }
            input = in.nextLine();
        }
        System.out.println("project1.Roster Manager terminated.");
    }
}
