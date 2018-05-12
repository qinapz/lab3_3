package edu.iis.mto.time;

import org.joda.time.DateTime;

public final class DateTimeSrc implements DateTimeSource {

    private int millisOffset;

    /** Return the system time + offset */
    @Override
    public DateTime currentTime() {
        return new DateTime().plusMillis(millisOffset);
    }

    public void setCurrentTimeOffsetMillis(final int millisOffset) {
        this.millisOffset = millisOffset;
    }

    public long getCurrentTimeOffsetMillis() {
        return millisOffset;
    }

}
