package edu.iis.mto.time;

import org.joda.time.DateTime;

public class GenericDateTimeSource implements DateTimeSource {
    private static DateTimeSource instance;
    private static DateTime dateTime;

    private GenericDateTimeSource() {
        this.dateTime = new DateTime();
    }

    public DateTimeSource getInstance() {
        if (instance == null) instance = new GenericDateTimeSource();
        return instance;
    }

    @Override
    public DateTime getCurrentDate() {
        return dateTime;
    }

    public DateTime forwardTime(int hours) {
        dateTime = dateTime.plusHours(hours);
        return dateTime;
    }
}
