package com.github.glo2003;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void whenEmptyString_thenReturnsZero() {
        int result = calculator.add("");

        assertEquals(0, result);
    }

    @Test
    void whenSingleValue_thenReturnsValue() {
        int result = calculator.add("1");

        assertEquals(1, result);
    }

    @Test
    void whenMultipleValue_thenReturnsTotal() {
        int result = calculator.add("1,2");

        assertEquals(3, result);
    }

    @Test
    void whenMissingValue_thenReturnsTotal() {
        int result = calculator.add("1,");

        assertEquals(1, result);
    }

    @Test
    void whenMultipleSeparator_thenReturnsTotal() {
        int result = calculator.add("1,,3");

        assertEquals(4, result);
    }

    @Test
    void whenInvalidValue_thenThrowsInvalidNumberFromatException() {
        assertThrows(InvalidNumberFormatException.class,
                () -> calculator.add("4,a"));
    }

    @Test
    void whenThreeAmounts_thenReturnsTotal() {
        int result = calculator.add("1,2,3");

        assertEquals(6, result);
    }

    @Test
    void whenMultipleAmounts_thenReturnsTotal() {
        int result = calculator.add("1,2,3,4,5");

        assertEquals(15, result);
    }

    @Test
    void whenMultipleAmountsWithCommas_thenReturnsTotal() {
        int result = calculator.add("1,7,,,,,3,,");

        assertEquals(11, result);
    }

    @Test
    void whenNewlineAndComma_thenReturnsTotal() {
        int result = calculator.add("1\n2,,3");

        assertEquals(6, result);
    }

    @Test
    void whenNewlineNextToComma_thenReturnsTotal() {
        int result = calculator.add("1,\n");

        assertEquals(1, result);
    }
}