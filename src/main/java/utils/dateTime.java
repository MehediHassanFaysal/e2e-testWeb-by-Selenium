package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class dateTime {
    public DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public LocalDateTime now = LocalDateTime.now();
//    public static String dateFormat = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

    public static String dateFormat = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(new Date());
    static long nanoTime = System.nanoTime();
    //dateFormat.format(new Date());
}
