package edu.usf.sas.pal.muser.test;

import edu.usf.sas.pal.muser.utils.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests utilities for String functionality
 */
public class StringUtilsTest {

    /**
     * Given a series of strings, verify the behavior of validateStringDateAndParseToMillis
     * to identify if each of the strings represent valid dates.
     */
    @Test
    public void testValidateStringDateAndParseToMillis() {
        String strDate1 = "02-29-2021";
        String strDate2 = "02-29-2020"; // 1582934400000L Etc/UTC
        String strDate3 = "02152021";
        String strDate4 = "02-18-2021"; // 1613606400000L Etc/UTC
        String strDate5 = "21-05-2020";
        String strDate6 = "May-05-2020";
        String strDate7 = "Hello World";
        String strDate8 = "123456788";

        // Verify for a invalid leap year
        assertEquals(0, StringUtils.validateStringDateAndParseToMillis(strDate1));

        // Verify valid leap year
        assertEquals(1582934400000L, StringUtils.validateStringDateAndParseToMillis(strDate2));

        //Verify invalid format
        assertEquals(0, StringUtils.validateStringDateAndParseToMillis(strDate3));

        //Verify valid date
        assertEquals(1613606400000L, StringUtils.validateStringDateAndParseToMillis(strDate4));

        //Verify valid date, invalid format
        assertEquals(0, StringUtils.validateStringDateAndParseToMillis(strDate5));
        assertEquals(0, StringUtils.validateStringDateAndParseToMillis(strDate6));

        //Verify invalid strings
        assertEquals(0, StringUtils.validateStringDateAndParseToMillis(strDate7));
        assertEquals(0, StringUtils.validateStringDateAndParseToMillis(strDate8));

    }

}
