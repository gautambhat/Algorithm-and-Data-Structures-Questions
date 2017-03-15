import java.util.*;

public class DateCalendar {
        
    public enum Day {
    
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY

    }

    public static Day[] days = {Day.SATURDAY, Day.SUNDAY, Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY};
    
    static class Date {
        
        int dd;
        int mm;
        int yyyy;
        Day day;

        Date(int d, int m, int y) {
        
            dd = d;
            mm = m;
            yyyy = y;
            day = getDay();

        }

        public boolean isLeapYear(int y) {
        
            return (y%4 == 0 || (y%400 == 0 && y%100 == 0));
        }
        

        public Day getDay() {
        
            if(dd == 1 && mm == 1 && yyyy == 1) {
                return Day.SATURDAY;
            }
            
            int dayCount = 0;

            for (int y = 1; y < yyyy; y++) {
                
                if (isLeapYear(y)) {
                    dayCount += 366;
                } else dayCount += 365;
            }

            for (int m = 1; m < mm; m++) {
            
                if ( m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12 ) {
                    dayCount += 31;
                } else if ( m == 4 || m == 6 || m == 9 || m == 11 ) {
                    dayCount += 30;
                } else if ( m == 2 && isLeapYear(yyyy)) {
                    dayCount += 29;
                } else {
                    dayCount += 28;
                }
            }

            dayCount += dd;
            
            return days[dayCount%7]; 

        }

    }


    public static void main(String[] args) {
    
        String[] ddmmyyyy = args[0].split("/");
        
        Date date = new Date(Integer.parseInt(ddmmyyyy[1]), Integer.parseInt(ddmmyyyy[0]), Integer.parseInt(ddmmyyyy[2]));

        System.out.println("The day on " + args[0] + " was " + date.day);

    }

}
