package project1;
/**
 Represents a Student object which holds a Profile object, a major, and credits completed.
 @author David Harianto, Joban Singh
 **/
public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major; //Major is an enum type
    private int creditCompleted;

    /**
     This is a constructor that takes in 5 parameters for a student.
     @author David Harianto, Joban Singh
     **/
    public Student (String first, String last, String birth, String m, double credits) {
        first = first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase();
        last = last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
        profile = new Profile(first, last, new Date(birth));
        try {
            major = Major.valueOf(m.toUpperCase());
        } catch (IllegalArgumentException e) {
            major = Major.UNKNOWN;
        }
        creditCompleted = (int) credits;
    }
    /**
     This is a constructor that takes in 3 parameters for a student.
     @author David Harianto, Joban Singh
     **/
    public Student (String first, String last, String birth) {
        first = first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase();
        last = last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
        profile = new Profile(first, last, new Date(birth));
    }
    /**
     This is a constructor that takes in 4 parameters for a student.
     @author David Harianto, Joban Singh
     **/
    public Student (String first, String last, String birth, String m) {
        first = first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase();
        last = last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
        profile = new Profile(first, last, new Date(birth));
        try {
            major = Major.valueOf(m.toUpperCase());
        } catch (IllegalArgumentException e) {
            major = Major.UNKNOWN;
        }
    }

    // Check if the major is listed in the enum class for the majors
    /**
     This method checks if the major is valid.
     @author David Harianto, Joban Singh
     **/
    public boolean validMajor(Major m) {
        if(m == Major.CS || m == Major.EE || m == Major.ITI || m == Major.MATH || m == Major.BAIT) {
            return true;
        }
        else {
            return false;
        }
    }

    // Check if the credits are valid, must not be negative
    /**
     This method checks if the amount of credits is valid.
     @author David Harianto, Joban Singh
     **/
    public boolean validCredits(int credits) {
        return (credits > 0);
    }

    /**
     This method changes the student major.
     @author David Harianto, Joban Singh
     **/
    public boolean changeMajor(Major m) {
        this.major = m;
        return true;
    }

    /**
     This method checks what the standing is of the student.
     @author David Harianto, Joban Singh
     **/
    public String getStanding() {
        if(this.creditCompleted < 30) {
            return "Freshman";
        }
        else if(this.creditCompleted < 60) {
            return "Sophomore";
        }
        else if(this.creditCompleted < 90) {
            return "Junior";
        }
        else {
            return "Senior";
        }
    }
    /**
     This method sets the amount of credits.
     @author David Harianto, Joban Singh
     **/
    public void setCredit(int credits) {
        creditCompleted = credits;
    }
    /**
     This method returns the profile.
     @author David Harianto, Joban Singh
     **/
    public Profile getProfile() {
        return this.profile;
    }
    /**
     This method returns the major.
     @author David Harianto, Joban Singh
     **/
    public Major getMajor() {
        return this.major;
    }
    /**
     This method returns the amount of credits completed.
     @author David Harianto, Joban Singh
     **/
    public int getCreditCompleted() {
        return this.creditCompleted;
    }

    /**
     This method returns the major code, school name, and credits completed.
     @author David Harianto, Joban Singh
     **/
    @Override
    public String toString() {
        // return project1.Student info
        return this.profile.toString() + " (" + this.major.getCode() + " " + this.major +
                " " + this.major.getSchool() + ")" + " credits completed: " + creditCompleted
                + " (" + this.getStanding() + ")";
    }

    /**
     This method checks if the student given is the same student.
     @author David Harianto, Joban Singh
     **/
    @Override
    public boolean equals(Object object) {
        // Compare two students
        if(this == object) {
            return true;
        }
        if(!(object instanceof Student)) {
            return false;
        }
        Student s = (Student) object;
        return this.profile.equals(s.profile);
    }
    /**
     This method returns a number when comparing a given student.
     @author David Harianto, Joban Singh
     **/
    @Override
    public int compareTo(Student s) {
        // return int when comparing students
        return this.profile.compareTo(s.profile);
    }
    /**
     This method provides the test cases for the student class.
     @author David Harianto, Joban Singh
     **/
    public static void main(String[] args) {
        // Test cases for Student
        // Test cases for project1.Student
        System.out.println("Test1: The output should return -1.");
        Student s1 = new Student("Carl", "Brown", "10/7/2004", "EE", 10);
        Student s2 = new Student("Kate", "Lindsey ", "7/15/2002", "EE", 10);
        System.out.println(s1.compareTo(s2));

        System.out.println("Test2: The output should return -1.");
        Student s3 = new Student("April", "Doe ", "1/20/2003", "EE", 10);
        Student s4 = new Student("John", "Doe ", "1/20/2003", "EE", 10);
        System.out.println(s3.compareTo(s4));

        System.out.println("Test3: The output should return 0.");
        Student s5 = new Student("Jane", "Doe", "5/1/1996", "EE", 10);
        Student s6 = new Student("Jane", "Doe", "5/1/1996", "EE", 10);
        System.out.println(s5.compareTo(s6));

        System.out.println("Test4: The output should return 1.");
        Student s7 = new Student("Mary", "Lindsey ", "12/1/2001", "EE", 10);
        Student s8 = new Student("Roy", "Brooks ", "8/8/1999", "EE", 10);
        System.out.println(s7.compareTo(s8));

        System.out.println("Test5: The output should return 1.");
        Student s9 = new Student("Jane", "Doe", "5/1/1996", "EE", 10);
        Student s10 = new Student("April", "Doe ", "1/20/2003", "EE", 10);
        System.out.println(s9.compareTo(s10));

    }
}
