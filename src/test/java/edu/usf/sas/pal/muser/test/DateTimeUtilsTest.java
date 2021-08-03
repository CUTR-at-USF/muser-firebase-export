package edu.usf.sas.pal.muser.test;

import edu.usf.sas.pal.muser.utils.DateTimeUtil;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Tests utilities for date-time validation
 */
public class DateTimeUtilsTest {

    /**
     * Given a series of long, verify the behavior of validateDatesProvided
     * to identify if each of the date ranges represent a valid date.
     */
    @Test
    public void testValidateDatesProvided() {

        long[] dateRange1 = {1609459200000L, 1609459200000L};
        long[] dateRange2 = {1609459200000L, 1611964800000L};
        long[] dateRange3 = {1588291200000L, 1612137600000L};
        long[] dateRange4 = {1611964800000L, 1609459200000L}; // end date greater than start date
        long[] dateRange5 = {0, 1611964800000L};
        long[] dateRange6 = {1609459200000L, 0};
        long[] dateRange7 = {0, 0};

        // Verify startDate equal to endDate result
        assertFalse(DateTimeUtil.validateDatesProvided(dateRange1[0], dateRange1[1]));

        // Verify valid startDate and endDate range
        assertTrue(DateTimeUtil.validateDatesProvided(dateRange2[0], dateRange2[1]));
        assertTrue(DateTimeUtil.validateDatesProvided(dateRange3[0], dateRange3[1]));

        // Verify invalid startDate and endDate range
        assertFalse(DateTimeUtil.validateDatesProvided(dateRange4[0], dateRange4[1]));
        assertFalse(DateTimeUtil.validateDatesProvided(dateRange5[0], dateRange5[1]));
        assertFalse(DateTimeUtil.validateDatesProvided(dateRange6[0], dateRange6[1]));
        assertFalse(DateTimeUtil.validateDatesProvided(dateRange7[0], dateRange7[1]));

    }

}
