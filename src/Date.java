public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    public Date() {} //create an object with today’s date (see Calendar class)
    public Date(String date) {} //take “mm/dd/yyyy” and create a Date object
    public boolean isValid() { } //check if a date is a valid calendar date

    @Override
    public String toString() {
        // return Date info
        return "";
    }
    @Override
    public boolean equals(Object o) {
        // Compare two dates
        return false;
    }
    @Override
    public int compareTo(Date d) {
        // return int when comparing dates
        return 0;
    }
}
