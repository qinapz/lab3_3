package edu.iis.mto.time;

import org.joda.time.DateTime;

public interface DateTimeSource {

    /** Return the system time. */
    DateTime currentTime();

}