package server.web.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public static Date parseFromStringToDate(String date, String format)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date date1 = simpleDateFormat.parse(format);
            return date1;
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Incorrect format");
            return null;
        }

    }

}
