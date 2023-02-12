public class Profile implements Comparable<Profile> {
    private String lname;
    private String fname;
    private Date dob; //use the Date class described in (f)

    public Profile(String firstName, String lastName, Date birthdate)
    {
        fname = firstName;
        lname = lastName;
        dob = birthdate;
    }

    @Override
    public String toString()
    {
        // return Profile info
        return "";
    }
    @Override
    public boolean equals(Object o)
    {
        // Compare two profiles
        return false;
    }
    @Override
    public int compareTo(Profile p) {
        // return int when comparing students
        if(lname.compareTo(p.lname) < 0) {
            return -1;
        }
        else if(lname.compareTo(p.lname) > 0) {
            return 1;
        }
        else {
            if (fname.compareTo(p.fname) < 0) {
                return -1;
            } else if (fname.compareTo(p.fname) > 0) {
                return 1;
            } else {
                if (dob.compareTo(p.dob) < 0) {
                    return -1;
                } else if (dob.compareTo(p.dob) > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}