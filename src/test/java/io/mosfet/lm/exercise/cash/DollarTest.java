package io.mosfet.lm.exercise.cash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("given a value with some digits in the right side, when creating a dollar, then truncate it")
    void givenAValueWithSomeRightDigits_whenCreatingADollar_thenTruncateIt() {
        Money actualMoney = new Dollar(1.11111);
        assertEquals(1.11, actualMoney.asDouble());
    }

    @Test
    @DisplayName("given a value with some digits in the right side, when creating a dollar, truncate it and round it")
    void givenAValueWithSomeRightDigits_whenCreatingADollar_thenTruncateItAndRound() {
        Money actualMoney = new Dollar(1.11511);
        assertEquals(1.12, actualMoney.asDouble());
    }

    @Test
    @DisplayName("given a value with some digits in the right side, when creating a dollar, truncate it without rounding")
    void givenAValueWithSomeRightDigits_whenCreatingADollar_thenTruncateItWithoutRounding() {
        Money actualMoney = new Dollar(1.11411);
        assertEquals(1.11, actualMoney.asDouble());
    }

    @Test
    @DisplayName("given two different dollars, when doing the sum, then return the result of the addition")
    void givenTwoDifferentDollars_whenDoingTheSum_thenReturnTheResultOfTheSum() {
        Money actualSum = new Dollar(1.11).add(new Dollar(1.15));
        assertEquals(new Dollar(2.26), actualSum);
    }

    @Test
    @DisplayName("given two different dollars, when doing the sum, then return the result of the addition")
    void givenTwoDifferentValueDollars_whenDoingTheSum_thenReturnTheResultOfTheSum() {
        Money actualSum = new Dollar(1.15).add(new Dollar(1.15));
        assertEquals(new Dollar(2.30), actualSum);
    }
}