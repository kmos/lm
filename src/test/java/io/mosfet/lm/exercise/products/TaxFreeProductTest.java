package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TaxFreeProductTest {

    @Test
    @DisplayName("given a product, when getting the cost, return it correctly")
    void givenProduct_whenGettingCost_thenReturnItCorrectly() {
        Product product = new TaxFreeProduct("book", Dollar.valueOf(1.01));
        Money actualMoney = product.getCost();

        assertEquals(BigDecimal.valueOf(1.01), actualMoney.asBigDecimal());
    }

    @Test
    @DisplayName("given null parameters, when creating a product, return a NullPointerException")
    void givenNullValue_whenCreatingAProduct_thenReturnANullPointerException() {
        assertThrows(NullPointerException.class, () -> new TaxFreeProduct(null, null));
    }

    @Test
    @DisplayName("given a product, when getting taxes, then return zero")
    void givenAProduct_whenGettingTaxes_thenReturnZero() {
        Product product = new TaxFreeProduct("book", Dollar.valueOf(1.01));
        Money actualTaxes = product.getTaxes();
        assertEquals(Dollar.valueOf(0), actualTaxes);
    }

    @Test
    @DisplayName("given a product, when getting the description, then return it")
    void givenAProduct_whenGettingTheDescription_thenReturnIt() {
        Product product = new TaxFreeProduct("book", Dollar.valueOf(1.01));
        String actualDescription = product.getDescription();
        assertEquals("book", actualDescription);
    }

    @Test
    @DisplayName("given a book product, when getting toString, then get it formatted")
    void givenABookProduct_whenGettingToString_thenReturnItFormatted() {
        Product product = new TaxFreeProduct("book", Dollar.valueOf(1.01));
        String actualToString = product.toString();
        assertEquals("book: 1.01", actualToString);
    }
}