package project1;

/**
 Represents a RosterManager object which allows the user to enter commands
 @author David Harianto, Joban Singh
 **/

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
            if(input != "") {
                StringTokenizer st1 = new StringTokenizer(input, " ");
                String command = st1.nextToken();
                if(command.equals("A")) { // Add student to the roster
                    Student temp = new Student(st1.nextToken(), st1.nextToken(), st1.nextToken(), st1.nextToken());
                    try {
                        int credit = Integer.parseInt(st1.nextToken());
                        temp.setCredit(credit);
                        roster.add(temp);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Credits completed invalid: not an integer!");
                    }
                }
                else if(command.equals("R")) {
                    Student temp = new Student(st1.nextToken(), st1.nextToken(), st1.nextToken());
                    roster.remove(temp);
                }
                else if(command.equals("P"))
                    roster.print();
                else if(command.equals("PS"))
                    roster.printByStanding();
                else if(command.equals("PC"))
                    roster.printBySchoolMajor();
                else if(command.equals("L"))
                    roster.printSchool(st1.nextToken());
                else if(command.equals("C")) {
                    Student temp = new Student(st1.nextToken(), st1.nextToken(), st1.nextToken());
                    roster.majorChange(temp, st1.nextToken());
                }
                else
                    System.out.println(command + " is an invalid command!");
            }
            input = in.nextLine();
        }
        System.out.println("Roster Manager terminated.");
    }
}

