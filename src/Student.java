public class Student implements Comparable<Student> {
    private Profile profile;
    private Major major; //Major is an enum type
    private int creditCompleted;

    public Student (String first, String last, Date birth, Major m, int credits) {
        profile = new Profile(first, last, birth);
        major = m;
        creditCompleted = credits;
    }

    @Override
    public String toString()
    {
        // return Student info
        return "";
    }
    @Override
    public boolean equals(Object o)
    {
        // Compare two students
        return false;
    }
    @Override
    public int compareTo(Student s) {
        // return int when comparing students
        return 0;
    }
}
