package io.mosfet.lm.exercise.cash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("given a dollar with parameters")
class DollarTest {

    @Nested
    @DisplayName("when getting the internal value of Dollar")
    class GettingValue {

        @Test
        @DisplayName("given one dollar, when getting the value, then return it correctly")
        void givenOneDollar_whenGettingTheValue_thenReturnItCorrectly() {
            Money actualMoney = Dollar.valueOf(1);
            assertEquals(BigDecimal.ONE, actualMoney.asBigDecimal().stripTrailingZeros());
        }

        @Test
        @DisplayName("given zero dollar, when getting the value, then return it correctly")
        void givenZeroDollar_whenGettingTheValue_thenReturnItCorrectly() {
            Money actualMoney = Dollar.valueOf(0);
            assertEquals(BigDecimal.ZERO, actualMoney.asBigDecimal().stripTrailingZeros());
        }

        @Test
        @DisplayName("given 1.1 dollar, when getting the value, then return it correctly")
        void givenOneDotOneDollar_whenGettingTheValue_thenReturnItCorrectly() {
            Money actualMoney = Dollar.valueOf(1.1);
            assertEquals(BigDecimal.valueOf(1.1), actualMoney.asBigDecimal().stripTrailingZeros());
        }

    }

    @Nested
    @DisplayName("when creating a dollar")
    class WhenCreatingADollar {

        @Test
        @DisplayName("given a negative value, when creating a dollar, throw CashException")
        void givenANegativeValue_whenCreatingADollar_thenThrowNumberFormatException() {
            assertThrows(IllegalArgumentException.class, () -> Dollar.valueOf(-1));
        }

        @Test
        @DisplayName("given a value with some digits in the right side, when creating a dollar, then truncate it")
        void givenAValueWithSomeRightDigits_whenCreatingADollar_thenTruncateIt() {
            Money actualMoney = Dollar.valueOf(1.11111);
            assertEquals(BigDecimal.valueOf(1.11), actualMoney.asBigDecimal());
        }

        @Test
        @DisplayName("given a value with some digits in the right side, when creating a dollar, truncate it and round it")
        void givenAValueWithSomeRightDigits_whenCreatingADollar_thenTruncateItAndRound() {
            Money actualMoney = Dollar.valueOf(1.11511);
            assertEquals(BigDecimal.valueOf(1.12), actualMoney.asBigDecimal());
        }

        @Test
        @DisplayName("given a value with some digits in the right side, when creating a dollar, truncate it without rounding")
        void givenAValueWithSomeRightDigits_whenCreatingADollar_thenTruncateItWithoutRounding() {
            Money actualMoney = Dollar.valueOf(1.11411);
            assertEquals(BigDecimal.valueOf(1.11), actualMoney.asBigDecimal());
        }

    }

    @Nested
    @DisplayName("when doing the sum")
    class WhenDoingTheSum {

        @Test
        @DisplayName("given two different dollars, when doing the sum, then return the result of the addition")
        void givenTwoDifferentDollars_whenDoingTheSum_thenReturnTheResultOfTheSum() {
            Money actualSum = Dollar.valueOf(1.11).add(Dollar.valueOf(1.15));
            assertEquals(Dollar.valueOf(2.26), actualSum);
        }

        @Test
        @DisplayName("given two different dollars, when doing the sum, then return the result of the addition")
        void givenTwoDifferentValueDollars_whenDoingTheSum_thenReturnTheResultOfTheSum() {
            Money actualSum = Dollar.valueOf(1.15).add(Dollar.valueOf(1.15));
            assertEquals(Dollar.valueOf(2.30), actualSum);
        }

    }

    @Nested
    @DisplayName("when asking for rounding")
    class whenRoundingTheValue {

        @Test
        @DisplayName("given 1.03 dollar, when asking for rounding, then return it rounded to nearest 5 cents")
        void given1dot03Dollar_whenAskingForRounding_thenReturnItRounded() {
            Money money = Dollar.valueOf(1.03);

            Money actualMoney = money.getRoundingTo5Cents();

            assertEquals(Dollar.valueOf(1.05), actualMoney);
        }

        @Test
        @DisplayName("given 2.05 dollar, when asking for rounding, then return not rounded")
        void given2dot05Dollar_whenAskingForRounding_thenReturnItNotRounded() {
            Money money = Dollar.valueOf(2.05);

            Money actualMoney = money.getRoundingTo5Cents();

            assertEquals(Dollar.valueOf(2.05), actualMoney);
        }

        @Test
        @DisplayName("given 1.09 dollar, when asking for rounding, then return it rounded")
        void given1dot09Dollar_whenAskingForRounding_thenReturnItRounded() {
            Money money = Dollar.valueOf(1.09);

            Money actualMoney = money.getRoundingTo5Cents();

            assertEquals(Dollar.valueOf(1.10), actualMoney);
        }
    }

}