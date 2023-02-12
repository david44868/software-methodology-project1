public class Roster {
    private Student[] roster;
    private int size;
    private static final int NOT_VALID = -1;

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
    } //search the given student in roster
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
                if(!student.validCredits(student.getCreditCompleted())) {
                    return false;
                }
                else if(!student.validMajor(student.getMajor())){
                    return false;
                }

                // ** Need more else if to satisfy the dob conditions **
                // Any date of birth that is not a valid calendar date
                // The date of birth is today or a future date
                // A student who is less than 16 years old

                else {
                    roster[x] = student;
                    break;
                }
            }
        }
        return true;
    } //add student to end of array

    public boolean remove(Student student) {
        if(!this.contains(student)) {
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
            if(roster[x].equals(student)) {
                return true;
            }
        }
        return false;
    } //if the student is in roster
    public void print () {
        System.out.println("* Student roster sorted by last name, first name, DOB **");

    } //print roster sorted by profiles
    public void printBySchoolMajor() {

    } //print roster sorted by school major
    public void printByStanding() {

    } //print roster sorted by standing
}