package project1;

/**
 Represents a Roster object which holds an array of Students
 @author David Harianto, Joban Singh
 **/
public class Roster {
    private Student[] roster;
    private int size;
    private static final int NOT_VALID = -1;
    private static final int MINIMUM_AGE = 16;

    public Roster () {
        size = 4;
        roster = new Student[size];
    }

    private int find(Student student) {
        for(int x = 0; x < size; x++){
            if(roster[x].getProfile().equals(student.getProfile())){
                return x;
            }
        }
        return NOT_VALID;
    }
    //search the given student in roster
    private void grow() {
        Student[] temporary = new Student[size + 4];
        for (int x = 0; x < size; x++){
            temporary[x] = roster[x];
        }
        roster = temporary;
    } //increase the array capacity by 4
    public boolean add(Student student) {
        if(roster[size - 1] != null) {
            this.grow();
        }
        for (int x = 0; x < size; x++){
            if(roster[x] == null) {
                // Check if credits are valid
                if(!student.validCredits(student.getCreditCompleted())) {
                    badCredit(!student.validCredits(student.getCreditCompleted()));
                    return false;
                }
                // Check if major is valid
                else if(!student.validMajor(student.getMajor())){
                    badMajor(!student.validMajor(student.getMajor()), student);
                    return false;
                }
                // Check if student already exists
                else if(!checkEmpty()) {
                    if(this.contains(student)) {
                        this.studentExists(student);
                        return false;
                    }
                }
                else if(!student.getProfile().getDob().isValid()) {
                    badDate(!student.getProfile().getDob().isValid(), student);
                    return false;
                }
                else if(!validDate(student.getProfile().getDob())) {
                    underAge(!validDate(student.getProfile().getDob()), student);
                    return false;
                }
                else {
                    roster[x] = student;
                    studentAdded(student);
                    break;
                }
            }
        }
        return true;
    } //add student to end of array

    public void studentAdded(Student student) {
        System.out.println(student.getProfile() + " added to the roster.");
    }

    public void badCredit(boolean credit) {
        if(!credit) {
            System.out.println("Credits completed invalid: cannot be negative!");
        }
    }

    public boolean validDate(Date dob) {
        Date date = new Date();
        date.changeYear(date.getYear() - MINIMUM_AGE);
        if(dob.compareTo(date) > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void badDate(boolean date, Student student) {
        if(date) {
            System.out.println("DOB invalid: " + student.getProfile().getDob() + " not a valid calendar date!");
        }
    }
    public void underAge(boolean date, Student student) {
        if(date) {
            System.out.println("DOB invalid: " + student.getProfile().getDob() + " younger than 16 years old.");
        }
    }

    public void badMajor(boolean major, Student student) {
        if(!major) {
            System.out.println("Major code invalid: " + student.getMajor());
        }
    }

    public void studentExists(Student student) {
        if(this.contains(student)) {
            System.out.println(student.getProfile() + " is already in the roster.");
        }
    }
    public void invalidStudent(boolean invalid, Student student) {
        if(!invalid) {
            System.out.println(student.getProfile() + " is not in the roster.");
        }
    }

    public boolean remove(Student student) {
        if(checkEmpty()) {
            empty();
            return false;
        }
        if(!this.contains(student)) {
            invalidStudent(!this.contains(student), student);
            return false;
        }
        else {
            Student[] temporary = new Student[size];
            for(int x = 0; x < size; x++) {
                if(!roster[x].equals(student)) {
                    temporary[x] = roster[x];
                }
            }
            roster = temporary;
            return true;
        }
    }//maintain the order after remove
    public boolean contains(Student student) {
        for (int x = 0; x < size; x++) {
            if(roster[x] != null) {
                if(roster[x].equals(student))
                    return true;
            }
        }
        return false;
    } //if the student is in roster

    public void empty() {
        System.out.println("Student roster is empty!");
    }

    public boolean checkEmpty() {
        for (int x = 0; x < size; x++) {
            if(roster[x] != null) {
                return false;
            }
        }
        return true;
    }

    public void majorChange(Student student, String major) {
        if(checkEmpty()) {
            System.out.println("Student roster is empty!");
        }
        else if(!this.contains(student)) {
            System.out.println(student.getProfile() + " is not in the roster.");
        }
        else if(!student.validMajor(Major.valueOf(major.toUpperCase()))) {
            System.out.println("Major code invalid: " + major);
        }
        else {
            roster[this.find(student)].changeMajor(Major.valueOf(major));
            System.out.println(student + " major changed to " + major.toUpperCase());
        }
    }

    public int lastStudent() {
        int lastStudent = 0;
        for(int i = 0; i < size; i++) {
            if(roster[i] != null)
                lastStudent = i;
        }
        return lastStudent;
    }

    public void printSchool(String school) {
        if(checkEmpty()) {
            System.out.println("Student roster is empty!");
        }
        else {
            if(lastStudent() > 0) {
                for(int i = 0; i < lastStudent() + 1; i++) {
                    for(int j = 1; j < (lastStudent()); j++) {
                        if(roster[j-1].compareTo(roster[j]) > 0) {
                            Student temporary = roster[j - 1];
                            roster[j - 1] = roster[j];
                            roster[j] = temporary;
                        }
                    }
                }
            }
            System.out.println("* Students in SOE *");
            for(int i = 0; i < size; i++) {
                if(roster[i].getMajor().getSchool().equals(school)) {
                    System.out.println(roster[i]);
                }
            }
        }
        System.out.println("* end of list **");
    }

    public void print () {
        if(checkEmpty()) {
            System.out.println("Student roster is empty!");
        }
        else {
            if(lastStudent() > 0) {
                for(int i = 0; i < lastStudent() + 1; i++) {
                    for(int j = 1; j < lastStudent(); j++) {
                        if(roster[j-1].compareTo(roster[j]) > 0) {
                            Student temporary = roster[j - 1];
                            roster[j - 1] = roster[j];
                            roster[j] = temporary;
                        }
                    }
                }
            }
            System.out.println("* Student roster sorted by last name, first name, DOB **");
            for(int i = 0; i < size; i++) {
                System.out.println(roster[i]);
            }
            System.out.println("* end of roster **");
        }
    } //print roster sorted by profiles
    public void printBySchoolMajor() {
        if(checkEmpty()) {
            System.out.println("Student roster is empty!");
        }
        else {
            if(lastStudent() > 0) {
                for(int i = 0; i < lastStudent() + 1; i++) {
                    for(int j = 1; j < lastStudent(); j++) {
                        if(roster[j-1].getMajor().getSchool().compareTo(roster[j].getMajor().getSchool()) > 0)
                        {
                            Student temporary = roster[j - 1];
                            roster[j - 1] = roster[j];
                            roster[j] = temporary;
                        }
                        else if(roster[j-1].getMajor().getSchool().compareTo(roster[j].getMajor().getSchool()) == 0) {
                            if(roster[j-1].getMajor().compareTo(roster[j].getMajor()) > 0) {
                                Student temporary = roster[j - 1];
                                roster[j - 1] = roster[j];
                                roster[j] = temporary;
                            }
                            else if(roster[j-1].getMajor().compareTo(roster[j].getMajor()) == 0) {
                                if(roster[j-1].compareTo(roster[j]) > 0) {
                                    Student temporary = roster[j - 1];
                                    roster[j - 1] = roster[j];
                                    roster[j] = temporary;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("* Student roster sorted by school, major **");
            for(int i = 0; i < size; i++) {
                System.out.println(roster[i]);
            }
            System.out.println("* end of roster **");
        }

    } //print roster sorted by school major
    public void printByStanding() {
        if(checkEmpty()) {
            System.out.println("Student roster is empty!");
        }
        else {
            if(lastStudent() > 0) {
                for(int i = 0; i < lastStudent() + 1; i++) {
                    for(int j = 1; j < lastStudent(); j++) {
                        if(roster[j - 1].getStanding().compareTo(roster[j].getStanding()) > 0)
                        {
                            Student temporary = roster[j - 1];
                            roster[j - 1] = roster[j];
                            roster[j] = temporary;
                        }
                        else if(roster[j - 1].getStanding().compareTo(roster[j].getStanding()) == 0) {
                            if(roster[j-1].compareTo(roster[j]) > 0) {
                                Student temporary = roster[j - 1];
                                roster[j - 1] = roster[j];
                                roster[j] = temporary;
                            }
                        }
                    }
                }
            }
            System.out.println("* Student roster sorted by standing **");
            for(int i = 0; i < size; i++) {
                System.out.println(roster[i]);
            }
            System.out.println("* end of roster **");
        }
    } //print roster sorted by standing
}