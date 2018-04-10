package edu.iis.mto.time;


import org.joda.time.DateTime;

public final class TimeSrc implements TimeSource {

    private static DateTime dateTime;
    private static int totalTimeChange;
    private static TimeSrc instance;

    TimeSrc() {
        dateTime = DateTime.now();
    }

    public static TimeSrc getInstance() {
        if (instance == null) {
            instance = new TimeSrc();
        }
        return instance;
    }
    @Override
    public DateTime plusHours( int i){
        totalTimeChange+=i;
        dateTime=DateTime.now().plusHours( totalTimeChange );
        return dateTime;
    }
    @Override
    public DateTime minusHours( int i){
        totalTimeChange-=i;
        dateTime=DateTime.now().minusHours( totalTimeChange );
        return dateTime;
    }
    @Override
    public DateTime getDateTime(){
        System.out.println(dateTime);
        return dateTime;
    }
}
