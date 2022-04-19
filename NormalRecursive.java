package recursive;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NormalRecursive {
    public static void calculateTime(String start, String end) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(start);
            d2 = format.parse(end);

            // in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffMiliSeconds = diff % 1000;
            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.print(diffSeconds + " seconds,");
            System.out.print(diffMiliSeconds + " miliseconds.");
            System.out.println(diff);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int C(int n, int k) {
        if (k == 0 || k == n)
            return 1;
        else
            return C(n - 1, k - 1) + C(n - 1, k);
    }

    public static void main(String[] args) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime startDate = LocalDateTime.now();
        String start = startDate.format(myFormatObj);
        System.out.println(C(60, 40));
        LocalDateTime endDate = LocalDateTime.now();
        String end = endDate.format(myFormatObj);
        calculateTime(start, end);
    }
}