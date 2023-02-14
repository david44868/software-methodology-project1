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
    private static final int CURRENTYEAR = 2023;
    private static final int MAXIMUM_MONTH = 11;
    private static final int MINIMUM_MONTH = 0;
    private static final int MAXIMUM_DAY = 31;
    private static final int NOT_LEAP_YEAR_FEB = 28;
    private static final int LEAP_YEAR_FEB = 29;
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
        if (year > CURRENTYEAR) {
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
        if (day <= NOT_LEAP_YEAR_FEB) {
            return true;
        }
        if (balancer == Calendar.FEBRUARY) {
            if (day > NOT_LEAP_YEAR_FEB) {
                if (year % QUADRENNIAL == 0) {
                    if (year % CENTENNIAL == 0) {
                        if (year % QUATERCENTENNIAL == 0) {
                            if (day == LEAP_YEAR_FEB) {
                                return true;
                            }
                            return false;
                        } else {
                            if (day == LEAP_YEAR_FEB) {
                                return false;
                            }
                        }
                        return true;
                    } else {
                        if (year % QUADRENNIAL == 0) {
                            if (day == LEAP_YEAR_FEB) {
                                return true;
                            }
                            return false;
                        }
                    }
                    return false;
                } else {
                    if (year % QUADRENNIAL == 0) {
                        if (day == LEAP_YEAR_FEB) {
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            }
            return true;
        }
        if (day == MAXIMUM_DAY && ((balancer == Calendar.JANUARY) || (balancer == Calendar.MARCH) || (balancer == Calendar.MAY) || (balancer == Calendar.JULY) || (balancer == Calendar.AUGUST) || (balancer == Calendar.OCTOBER) || (balancer == Calendar.DECEMBER))) {
            return true;
        }
        if (day == MAXIMUM_DAY - 1 && balancer != Calendar.FEBRUARY + 1) {
            return true;
        }
        return false;
    }//check if a date is a valid calendar date

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

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public int compareTo(Date date) {
        if (year > date.getYear()) {
            return BEFORE;
        }
        if (year == date.getYear()) {
            if (month > date.getMonth()) {
                return BEFORE;
            }
            if (month == date.getMonth()) {
                if (day > date.getDay())
                    return BEFORE;
            }
            if (day == date.getDay()) {
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
        Date date1 = new Date("02/29/2015"); // Tests if a non-leap year and having the day 29 in the month Feb is valid.
        System.out.println(date1.toString() + ": " + date1.isValid());

        System.out.println("Test2: The output should return false.");
        Date date2 = new Date("02/00/2020");// Tests if having a 0 number for the date is valid.
        System.out.println(date2.toString() + ": " + date2.isValid());

        System.out.println("Test3: The output should return false.");
        Date date3 = new Date("13/01/2017");// Tests if having a month greater than 13 is valid.
        System.out.println(date3.toString() + ": " + date3.isValid());

        System.out.println("Test4: The output should return false.");
        Date date4 = new Date("01/01/-2000");// Tests if having a negative number for the year is valid.
        System.out.println(date4.toString() + ": " + date4.isValid());

        System.out.println("Test5: The output should return false.");
        Date date5 = new Date("02/20/3000");// Tests if having a single number for the year is valid.
        System.out.println(date5.toString() + ": " + date5.isValid());

        System.out.println("Test6: The output should return true.");
        Date date6 = new Date("02/29/2016");// Tests if a leap year and having the day 29 in the month Feb is valid.
        System.out.println(date6.toString() + ": " + date6.isValid());

        System.out.println("Test7: The output should return true.");
        Date date7 = new Date("09/2/2022");// Tests if having the day 31 is valid for January, March, May, July, August, October, December is valid.
        System.out.println(date7.toString() + ": " + date7.isValid());
    }
}