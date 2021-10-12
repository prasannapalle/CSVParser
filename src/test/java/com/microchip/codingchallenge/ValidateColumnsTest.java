package com.microchip.codingchallenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateColumnsTest {

    private ValidateColumns validateColumns = new ValidateColumns();

    @Test
    public void checkForInvalidFormats_InvalidDate() {
        String actual = validateColumns.checkForInvalidFormats("shipment_date", "34/8989");
        Assertions.assertEquals("invalid date", actual);
    }

    @Test
    public void checkForInvalidFormats_ValidDate() {
        String actual = validateColumns.checkForInvalidFormats("shipment_date", "02/02/2021");
        Assertions.assertEquals("2021/02/02", actual);
    }

    @Test
    public void checkForInvalidFormats_ship_qty_NaN() {
        String actual = validateColumns.checkForInvalidFormats("ship_qty", "2E");
        Assertions.assertEquals("invalid number", actual);
    }

    @Test
    public void checkForInvalidFormats_ship_qty_valid() {
        String actual = validateColumns.checkForInvalidFormats("ship_qty", "22");
        Assertions.assertEquals("22", actual);
    }

    @Test
    public void checkForInvalidFormats_ship_qty_invalid() {
        String actual = validateColumns.checkForInvalidFormats("ship_qty", " ");
        Assertions.assertEquals("0", actual);
    }

    @Test
    public void checkForInvalidFormats_shipment_date_invalid() {
        String actual = validateColumns.checkForInvalidFormats("shipment_date", " ");
        Assertions.assertEquals("null value", actual);
    }


}