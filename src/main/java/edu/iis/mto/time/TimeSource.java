package edu.iis.mto.time;

import org.joda.time.DateTime;

public class TimeSource implements TimeSourceInterface {

    @Override
    public DateTime dateTime() {
        return DateTime.now().plusHours(25);
    }

}
