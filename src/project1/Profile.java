package project1;

/**
 Represents a Profile object which consists of first name, last name, and Date
 @author David Harianto, Joban Singh
 **/
public class Profile implements Comparable<Profile> {
    private String lname;
    private String fname;
    private Date dob; //use the project1.Date class described in (f)

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
    public boolean equals(Object obj)
    {
        if(obj == this){
            return true;
        }
        // Compare two profiles
        if(!(obj instanceof Profile)){
            return false;
        }
        Profile temporary = (Profile) obj;
        return this.fname.toLowerCase().equals(temporary.getFirstname().toLowerCase()) && this.lname.toLowerCase().equals(temporary.getLastname().toLowerCase()) && this.dob.equals(temporary.getDob());
    }
    @Override
    public int compareTo(Profile p) {
        // return int when comparing students
        if(this.lname.toLowerCase().compareTo(p.lname.toLowerCase()) < 0) {
            return -1;
        }
        else if(this.lname.toLowerCase().compareTo(p.lname.toLowerCase()) > 0) {
            return 1;
        }
        else {
            if (this.fname.toLowerCase().compareTo(p.fname.toLowerCase()) < 0) {
                return -1;
            } else if (this.fname.toLowerCase().compareTo(p.fname.toLowerCase()) > 0) {
                return 1;
            } else {
                if (this.dob.compareTo(p.dob) < 0) {
                    return -1;
                } else if (this.dob.compareTo(p.dob) > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public String getFirstname(){
        return fname;
    }

    public String getLastname(){
        return lname;
    }

    public Date getDob(){
        return dob;
    }
}