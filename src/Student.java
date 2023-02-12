public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major; //Major is an enum type
    private int creditCompleted;

    public Student (String first, String last, Date birth, Major m, int credits) {
        profile = new Profile(first, last, birth);
        if(!validMajor(m)) {
            throw new IllegalArgumentException("Major code invalid: " + m);
        }
        else {
            major = m;
        }
        if(!validCredits(credits)) {
            throw new IllegalArgumentException("Negative credits not allowed.");
        }
        else {
            creditCompleted = credits;
        }

    }

    // Check if the major is listed in the enum class for the majors
    public boolean validMajor(Major m) {
        if(m == Major.CS || m == Major.EE || m == Major.ITI || m == Major.MATH || m == Major.BAIT) {
            major = m;
            return true;
        }
        else {
            return false;
        }
    }

    // Check if the credits are valid, must not be negative
    public boolean validCredits(int credits) {
        if(credits < 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public Profile getProfile() {
        return this.profile;
    }

    @Override
    public String toString() {
        // return Student info
        return this.profile.toString();
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
        if(this.profile.equals(s.profile)) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public int compareTo(Student s) {
        // return int when comparing students
        return this.profile.compareTo(s.profile);
    }
}
