package project1;

public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major; //project1.Major is an enum type
    private int creditCompleted;

    public Student (String first, String last, String birth, String m, int credits) {
        first = first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase();
        last = last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
        profile = new Profile(first, last, new Date(birth));
        major = Major.valueOf(m);
        creditCompleted = credits;

    }

    public Student (String first, String last, String birth) {
        first = first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase();
        last = last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
        profile = new Profile(first, last, new Date(birth));
    }

    // Check if the major is listed in the enum class for the majors
    public boolean validMajor(Major m) {
        if(m == Major.CS || m == Major.EE || m == Major.ITI || m == Major.MATH || m == Major.BAIT) {
            return true;
        }
        else {
            return false;
        }
    }

    // Check if the credits are valid, must not be negative
    public boolean validCredits(int credits) {
        return (credits < 0);
    }

    public boolean changeMajor(Major m) {
        if(this.validMajor(m)) {
            major = m;
            return true;
        }
        else {
            return false;
        }
    }

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

    public Profile getProfile() {
        return this.profile;
    }

    public Major getMajor() {
        return this.major;
    }

    public int getCreditCompleted() {
        return this.creditCompleted;
    }

    @Override
    public String toString() {
        // return project1.Student info
        return this.profile.toString() + "(" + this.major.getCode() + " " + this.major +
                " " + this.major.getSchool() + ")" + " credits completed: " + creditCompleted
                + " (" + this.getStanding() + ")";
    }
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
    @Override
    public int compareTo(Student s) {
        // return int when comparing students
        return this.profile.compareTo(s.profile);
    }
//    public static void main(String[] args) {
//        // Test cases for Date
//        // Test cases for project1.Date
//        System.out.println("Test1: The output should return false.");
//        Date date1 = new Date("02/29/2015"); // Tests if a non-leap year and having the day 29 in the month Feb is valid.
//        System.out.println(date1.toString() + ": " + date1.isValid());
//
//        System.out.println("Test2: The output should return false.");
//        Date date2 = new Date("02/00/2020");// Tests if having a 0 number for the date is valid.
//        System.out.println(date2.toString() + ": " + date2.isValid());
//
//        System.out.println("Test3: The output should return false.");
//        Date date3 = new Date("13/01/2017");// Tests if having a month greater than 13 is valid.
//        System.out.println(date3.toString() + ": " + date3.isValid());
//
//        System.out.println("Test4: The output should return false.");
//        Date date4 = new Date("01/01/-2000");// Tests if having a negative number for the year is valid.
//        System.out.println(date4.toString() + ": " + date4.isValid());
//
//        System.out.println("Test5: The output should return false.");
//        Date date5 = new Date("02/20/3");// Tests if having a single number for the year is valid.
//        System.out.println(date5.toString() + ": " + date5.isValid());
//
//        System.out.println("Test6: The output should return true.");
//        Date date6 = new Date("02/29/2016");// Tests if a leap year and having the day 29 in the month Feb is valid.
//        System.out.println(date6.toString() + ": " + date6.isValid());
//
//        System.out.println("Test7: The output should return true.");
//        Date date7 = new Date("01/31/2000");// Tests if having the day 31 is valid for January, March, May, July, August, October, December is valid.
//        System.out.println(date7.toString() + ": " + date7.isValid());
//    }
}
