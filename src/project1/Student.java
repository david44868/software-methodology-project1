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
}
