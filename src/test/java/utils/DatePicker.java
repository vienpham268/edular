package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePicker {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public DatePicker() {

    }

    /**
     * @param number gt 0 is after current date, lt 0 is before current date
     */
    public String getDateFromCurrentDate(int number) {
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, number);

        Date currentDatePlus = calendar.getTime();
        return simpleDateFormat.format(currentDatePlus);

    }
}
