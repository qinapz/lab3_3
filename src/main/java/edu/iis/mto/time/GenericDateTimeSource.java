package edu.iis.mto.time;

import org.joda.time.DateTime;

public class GenericDateTimeSource implements DateTimeSource {
    private static DateTimeSource instance;
    private static DateTime dateTime;

    private GenericDateTimeSource() {
        dateTime = new DateTime();
    }

    public static DateTimeSource getInstance() {
        if (instance == null) instance = new GenericDateTimeSource();
        return instance;
    }

    @Override
    public DateTime getCurrentDate() {
        return dateTime;
    }

    @Override
    public DateTime forwardTime(int hours) {
        dateTime = dateTime.plusHours(hours);
        return dateTime;
    }
}
