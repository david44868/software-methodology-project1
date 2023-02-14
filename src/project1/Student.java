package project1;

public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major; //project1.Major is an enum type
    private int creditCompleted;

    public Student (String first, String last, String birth, String m, double credits) {
        first = first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase();
        last = last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
        profile = new Profile(first, last, new Date(birth));
        major = Major.valueOf(m.toUpperCase());
        creditCompleted = (int) credits;
    }

    public Student (String first, String last, String birth) {
        first = first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase();
        last = last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
        profile = new Profile(first, last, new Date(birth));
    }

    public Student (String first, String last, String birth, String m) {
        first = first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase();
        last = last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
        profile = new Profile(first, last, new Date(birth));
        major = Major.valueOf(m.toUpperCase());
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
        return (credits > 0);
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

    public void setCredit(int credits) {
        creditCompleted = credits;
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
    public static void main(String[] args) {
        // Test cases for Student
        // Test cases for project1.Student
        System.out.println("Test1: The output should return -1.");
        Student s1 = new Student("Carl", "Brown", "10/7/2004", "EE", 10);
        Student s2 = new Student("Kate", "Lindsey ", "7/15/2002", "EE", 10);

        System.out.println("Test1: The output should return -1.");
        Student s3 = new Student("April", "Doe ", "1/20/2003", "EE", 10);
        Student s4 = new Student("John", "Doe ", "1/20/2003", "EE", 10);

        System.out.println("Test1: The output should return 0.");
        Student s5 = new Student("Jane", "Doe", "5/1/1996", "EE", 10);
        Student s6 = new Student("Jane", "Doe", "5/1/1996", "EE", 10);

        System.out.println("Test1: The output should return 1.");
        Student s7 = new Student("Mary", "Lindsey ", "12/1/2001", "EE", 10);
        Student s8 = new Student("Roy", "Brooks ", "8/8/1999", "EE", 10);

        System.out.println("Test1: The output should return 1.");
        Student s9 = new Student("Jane", "Doe", "5/1/1996", "EE", 10);
        Student s10 = new Student("April", "Doe ", "1/20/2003", "EE", 10);


        System.out.println(s1.compareTo(s2));
        System.out.println(s2.compareTo(s3));
        System.out.println(s5.compareTo(s1));
        System.out.println(s3.compareTo(s4));
        System.out.println(s4.compareTo(s5));

    }
}
