package io.mosfet.lm.exercise.cash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {

    @Test
    @DisplayName("given one dollar, when getting the value, then return it correctly")
    void givenOneDollar_whenGettingTheValue_thenReturnItCorrectly() {
        Money actualMoney = new Dollar(1);
        assertEquals(1, actualMoney.asDouble());
    }

    @Test
    @DisplayName("given zero dollar, when getting the value, then return it correctly")
    void givenZeroDollar_whenGettingTheValue_thenReturnItCorrectly() {
        Money actualMoney = new Dollar(0);
        assertEquals(0, actualMoney.asDouble());
    }

    @Test
    @DisplayName("given 1.1 dollar, when getting the value, then return it correctly")
    void givenOneDotOneDollar_whenGettingTheValue_thenReturnItCorrectly() {
        Money actualMoney = new Dollar(1.1);
        assertEquals(1.1, actualMoney.asDouble());
    }

    @Test
    @DisplayName("given a negative value, when creating a dollar, throw CashException")
    void givenANegativeValue_whenCreatingADollar_thenThrowNumberFormatException() {
        assertThrows(IllegalArgumentException.class, () -> new Dollar(-1));
    }
}