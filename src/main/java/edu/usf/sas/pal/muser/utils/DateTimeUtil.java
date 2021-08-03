package edu.usf.sas.pal.muser.utils;

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

}
