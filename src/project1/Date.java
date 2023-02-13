package project1;

import java.util.Calendar;
import java.util.StringTokenizer;


public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    private static final int QUADRENNIAL = 4;
    private static final int CENTENNIAL = 100;
    private static final int QUATERCENTENNIAL = 400;
    private static final int TWENTYTWENTYTHREE = 2023;
    private static final int MAXIMUM_MONTH = 11;
    private static final int MINIMUM_MONTH = 0;
    private static final int MAXIMUM_DAY = 31;
    private static final int MINIMUM_DAY = 1;
    private static final int SAME = 0;
    private static final int BEFORE = -1;
    private static final int AFTER = 1;

    public Date() {
        Calendar currentDate = Calendar.getInstance();
        month = currentDate.get(Calendar.MONTH) + 1;
        day = currentDate.get(Calendar.DAY_OF_MONTH);
        year = currentDate.get(Calendar.YEAR);
    } //create an object with today’s date (see Calendar class)

    public Date(String date) {
        StringTokenizer st1 = new StringTokenizer(date, "/");
        month = Integer.parseInt(st1.nextToken());
        day = Integer.parseInt(st1.nextToken());
        year = Integer.parseInt(st1.nextToken());

    } //take “mm/dd/yyyy” and create a Date object

    public boolean isValid() {
        int balancer = month - 1;//off set month
        if (year > TWENTYTWENTYTHREE) {
            return false;
        }
        if (month < MINIMUM_MONTH || balancer > MAXIMUM_MONTH) {
            return false;
        }
        if (day < MINIMUM_DAY || day > MAXIMUM_DAY) {
            return false;
        }
        if (this.compareTo(new Date()) <= SAME) {
            return false;
        }
        if (day <= MAXIMUM_DAY - 3) {
            return true;
        }
        if (day == MAXIMUM_DAY - 2) {
            if (balancer == Calendar.FEBRUARY) {
                if (year % QUADRENNIAL == 0) {
                    if (year % CENTENNIAL == 0) {
                        if (year % QUATERCENTENNIAL == 0) {
                            return true;
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }
        if(day == MAXIMUM_DAY - 1 && balancer != Calendar.FEBRUARY + 1){
            return true;
        }
        if (day == MAXIMUM_DAY && ((balancer == Calendar.JANUARY) || (balancer == Calendar.MARCH) || (balancer == Calendar.MAY) || (balancer == Calendar.JULY) || (balancer == Calendar.AUGUST) || (balancer == Calendar.OCTOBER) || (balancer == Calendar.DECEMBER))){
            return true;
        }
        return false;
    } //check if a date is a valid calendar date
    @Override
    public String toString() {
        // return project1.Date info
        return month + "/" + day + "/" + year;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Date date = (Date) o;
        return year == date.year && month == date.month && day == date.day;
    }
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    @Override
    public int compareTo(Date date) {
        if(year > date.getYear()){
            return BEFORE;
        }
        if(year == date.getYear()){
            if(month > date.getMonth()) {
                return BEFORE;
            }
            if(month == date.getMonth()) {
                if (day > date.getDay())
                    return BEFORE;
            }
            if(day == date.getDay()) {
                return SAME;
            }
        }
        // return int when comparing dates
        return AFTER;
    }
    public static void main(String[] args) {
        // Test cases for Date
        // Test cases for project1.Date
        System.out.println("Test1: The output should return false.");
        Date date1 = new Date("02/30/2022");
        System.out.println(date1.toString() + ": " + date1.isValid());
        System.out.println("Test2: The output should return true.");
        Date date2 = new Date("02/28/2021");
        System.out.println(date2.toString() + ": " + date2.isValid());
        System.out.println("Test3: The output should return true.");
        Date date3 = new Date("02/29/2016");
        System.out.println(date3.toString() + ": " + date3.isValid());
    }
}