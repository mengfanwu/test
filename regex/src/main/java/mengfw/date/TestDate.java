package mengfw.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf1.format(new Date());
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf2.parse(format);
        System.out.println(parse.toString());
    }
}
