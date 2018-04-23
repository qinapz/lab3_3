package edu.iis.mto.time;

import org.joda.time.DateTime;

public interface TimeSource {

    /** Return the system time. */
    DateTime plusHours( int i);
    DateTime minusHours( int i);
    DateTime getDateTime();

}
