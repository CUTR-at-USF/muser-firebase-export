package edu.usf.sas.pal.muser.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtil {

    /**
     * Gets the dates in milliseconds and validates them
     * @param dateStartMillis long with startDate to validate
     * @param dateEndMillis long with endDate to validate
     * @return true if both dates are greater than 0 and a valid range holds, false otherwise
     */
    public static boolean validateDatesProvided(long dateStartMillis, long dateEndMillis) {
        if (dateStartMillis > 0 && dateEndMillis > 0) {
            if (dateStartMillis < dateEndMillis) return true;
            else return false;
        } else return false;
    }

    /**
     * Gets the time in the string ISO 8601 UTC format from the provided epoch time
     * @param millis
     * @return the time in the string ISO 8601 UTC format from the provided epoch time
     */
    public static String getDateAndTimeFromMillis(Long millis) {
        if (millis == null) return "";
        Date date = new Date(millis);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        // Set time zone to GMT to obtain timestamp as UTC date
        sdf.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        return sdf.format(date);
    }

}
