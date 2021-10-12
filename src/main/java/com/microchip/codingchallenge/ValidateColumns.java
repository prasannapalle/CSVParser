package com.microchip.codingchallenge;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/***
 * ValidateColumns is used to validate columns - shipment_date, ship_qty and MPC
 */
public class ValidateColumns {
    /**
     * Validates inputs based on the given column name
     *
     * @param s
     * @param array
     * @return string
     */
    public String checkForInvalidFormats(String s, String array) {
        String str = array;
        if (s.equalsIgnoreCase("shipment_date")) {
            if (array.trim().length() > 0) {
                try {

                    DateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
                    sdf.setLenient(false);
                    sdf.parse(array);
                    DateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
                    DateFormat targetFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date date = originalFormat.parse(array);
                    str = targetFormat.format(date);  // 20120821
                } catch (Exception pe) {
                    str = "invalid date";
                }
            } else {
                str = "null value";
            }

        } else if (s.equalsIgnoreCase("mpc")) {
            if (array.trim().length() > 0)
                str = array.substring(0, 5);
            else {
                str = "invalid data";
            }
        }


        if (s.equalsIgnoreCase("ship_qty")) {
            if (array.trim().length() > 0) {
                try {
                    int x = Integer.parseInt(array);

                } catch (NumberFormatException ne) {
                    str = "invalid number";
                }
            } else {
                str = "0";
            }
        }

        return str;
    }
}
