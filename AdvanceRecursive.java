package recursive;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AdvanceRecursive {
    public static long N = 50;
    public static long K = 30;
    public static long[][] D = new long[(int) (N + 2)][(int) (N + 2)];

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

    public static long C(long n2, long k2) {
        if (D[(int) n2][(int) k2] > 0) {
            return D[(int) n2][(int) k2];
        } else {
            D[(int) n2][(int) k2] = C(n2 - 1, k2 - 1) + C(n2 - 1, k2);
            return D[(int) n2][(int) k2];
        }
    }

    public static void main(String[] args) {
        for (long i = 0; i <= N; i++) {
            for (long j = 0; j <= N; j++) {
                if (j == 0 || j == N || i == j)
                    D[(int) i][(int) j] = 1;
                else
                    D[(int) i][(int) j] = 0;
            }
        }
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:ns");
        LocalDateTime startDate = LocalDateTime.now();
        String start = startDate.format(myFormatObj);
        System.out.println(C(N, K));
        LocalDateTime endDate = LocalDateTime.now();
        String end = endDate.format(myFormatObj);
        calculateTime(start, end);
    }
}
