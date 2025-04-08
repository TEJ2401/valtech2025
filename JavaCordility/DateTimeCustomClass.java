package cordility.assignments;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeCustomClass {
	public static class DateTime {
        private LocalDateTime dateTime;
        
        public DateTime(int year, int month, int day, int hour, int minute, int second) {
            this.dateTime = LocalDateTime.of(year, month, day, hour, minute, second);
        }

        public String timeDifference(DateTime other) {
            Duration duration = Duration.between(this.dateTime, other.dateTime);
            long years = ChronoUnit.YEARS.between(this.dateTime, other.dateTime);
            long months = ChronoUnit.MONTHS.between(this.dateTime, other.dateTime) % 12;
            long days = ChronoUnit.DAYS.between(this.dateTime, other.dateTime) % 365;
            long hours = duration.toHours() % 24;
            long minutes = duration.toMinutes() % 60;
            long seconds = duration.getSeconds() % 60;

            return String.format("Difference: %d years, %d months, %d days, %d hours, %d minutes, %d seconds",
                    years, months, days, hours, minutes, seconds);
        }

        public static DateTime now() {
            LocalDateTime currentDateTime = LocalDateTime.now();
            return new DateTime(currentDateTime.getYear(), currentDateTime.getMonthValue(),
                    currentDateTime.getDayOfMonth(), currentDateTime.getHour(),
                    currentDateTime.getMinute(), currentDateTime.getSecond());
        }

        @Override
        public String toString() {
            return this.dateTime.toString();
        }
    }

    public static void main(String[] args) {

        DateTime dateTime1 = new DateTime(2023, 5, 15, 14, 30, 0);
        DateTime dateTime2 = new DateTime(2025, 9, 18, 17, 45, 30);

        System.out.println("DateTime 1: " + dateTime1);
        System.out.println("DateTime 2: " + dateTime2);


        System.out.println(dateTime1.timeDifference(dateTime2));
        

        DateTime currentDateTime = DateTime.now();
        System.out.println("\nCurrent DateTime: " + currentDateTime);
        System.out.println("Difference from DateTime1: " + currentDateTime.timeDifference(dateTime1));
    }
}
