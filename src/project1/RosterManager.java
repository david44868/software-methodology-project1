package project1;

import project1.Student;

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
            if(command.equals("A")) {
                if(roster.add(new Student(st1.nextToken(), st1.nextToken(), st1.nextToken(), st1.nextToken(), Integer.parseInt(st1.nextToken()))))
                    System.out.println();
            }
            if(command.equals("R"))
                if(roster.remove(roster.search(st1.nextToken(), st1.nextToken(), st1.nextToken())))
                    System.out.println();
            if(command.equals("P"))
                roster.print();
            if(command.equals("PS"))
                roster.printByStanding();
            if(command.equals("PC"))
                roster.printBySchoolMajor();
            if(command.equals("L")) {

            }
            if(command.equals("C")) {
                String fname = st1.nextToken(), lname = st1.nextToken(), date = st1.nextToken();
                Student temp = new Student(fname, lname, date);
                if(roster.contains(temp))
                    System.out.println(fname + " " + lname + " " + date + " is not in the roster.");
                else
                    System.out.println(fname + " " + lname + " " + date + " added to the roster.");
            }
            else {
                System.out.println(command + "is an invalid command!");
            }
            input = in.nextLine();
        }
        System.out.println("Roster Manager terminated.");
    }
}

