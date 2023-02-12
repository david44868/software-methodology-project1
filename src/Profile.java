public class Profile implements Comparable<Profile> {
    private String lname;
    private String fname;
    private Date dob; //use the Date class described in (f)

    public Profile(String fname, String lname, Date dob)
    {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    @Override
    public String toString()
    {
        return fname + " " + lname + " " + dob;
    }
    @Override
    public boolean equals(Object o)
    {
        if(obj == this){
            return true;
        }
        // Compare two profiles
        if(!(obj instanceof Profile)){
            return false;
        }
        Profile temporary = (Profile) obj;
        return fname.equals(temporary.getfname()) && lname.equals(temporary.getlname()) && dob.equals(temporary.getdob());
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

    public String getfname(){
        return fname;
    }

    public String getlname(){
        return lname;
    }

    public Date getdob(){
        return dob;
    }
}