public class Roster {
    private Student[] roster;
    private int size;
<<<<<<<<< Temporary merge branch 1

    public Roster () {
        size = 4;
        roster = new Student[size];
    }

    private int find(Student student) {} //search the given student in roster
    private void grow() {} //increase the array capacity by 4
    public boolean add(Student student){} //add student to end of array
=========
    private static final int NOT_VALID = -1;
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
    public boolean add(Student student){

    } //add student to end of array
>>>>>>>>> Temporary merge branch 2
    public boolean remove(Student student){}//maintain the order after remove
    public boolean contains(Student student){} //if the student is in roster
    public void print () {} //print roster sorted by profiles
    public void printBySchoolMajor() {} //print roster sorted by school major
    public void printByStanding() {} //print roster sorted by standing
}