package server.web.Utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public static Date parseFromStringToDate(String dateStr, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = dateFormat.parse(dateStr, parsePosition);
        if (date != null)
            return date;
        else {
            System.out.println("Pattern is incorrect");
            return null;
        }
    }
}
