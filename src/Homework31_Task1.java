import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Homework31_Task1{

    enum Month {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER,
    }

    enum Season {
        WINTER,
        SPRING,
        SUMMER,
        AUTUMN,

    }

    public static Map<Month, Season> buildSeasonMap() {
        Map<Month, Season> season = new HashMap<>();
        season.put(Month.JANUARY, Season.WINTER);
        season.put(Month.FEBRUARY, Season.WINTER);
        season.put(Month.DECEMBER, Season.WINTER);
        season.put(Month.MARCH, Season.SPRING);
        season.put(Month.APRIL, Season.SPRING);
        season.put(Month.MAY, Season.SPRING);
        season.put(Month.JUNE, Season.SUMMER);
        season.put(Month.JULY, Season.SUMMER);
        season.put(Month.AUGUST, Season.SUMMER);
        season.put(Month.SEPTEMBER, Season.AUTUMN);
        season.put(Month.OCTOBER, Season.AUTUMN);
        season.put(Month.NOVEMBER, Season.AUTUMN);
        return season;
    }

    public static Map<Month, Integer> buildMonthsMap() {
        Map<Month, Integer> months = new HashMap<>();

        months.put(Month.JANUARY, 31);
        months.put(Month.FEBRUARY, 28);
        months.put(Month.MARCH, 31);
        months.put(Month.APRIL, 30);
        months.put(Month.MAY, 31);
        months.put(Month.JUNE, 30);
        months.put(Month.JULY, 31);
        months.put(Month.AUGUST, 31);
        months.put(Month.SEPTEMBER, 30);
        months.put(Month.OCTOBER, 31);
        months.put(Month.NOVEMBER, 30);
        months.put(Month.DECEMBER, 31);

        return months;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the month: ");
        String month = inputReader.readLine();
        Month monthToLook = Month.valueOf(month.toUpperCase());
        Map<Month, Season> season = buildSeasonMap();
        Map<Month, Integer> monthDays = buildMonthsMap();
        if (monthDays.containsKey(monthToLook)) {
            System.out.printf("The month '%s' contains %d days%n", month, monthDays.get(monthToLook));
            System.out.println("The season is " + season.get(monthToLook));
            System.out.printf("The month '%s' has ordinal number %d%n", month, monthToLook.ordinal() + 1);
            int nextMonthIndex = (monthToLook.ordinal() + 1);
            Month nextMonth = Month.values()[nextMonthIndex % Month.values().length];
            System.out.printf("The next month is '%s'%n", nextMonth);
            System.out.printf("The reason next month is '%s'%n", season.get(nextMonth));
            System.out.printf("It has %d days", monthDays.get(nextMonth));
        } else {
            System.out.println("No such month: " + month);
        }
    }
}
