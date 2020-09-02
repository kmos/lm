package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxFreeProductTest {

    @Test
    @DisplayName("given a product, when getting the cost, return it correctly")
    void givenProduct_whenGettingCost_returnItCorrectly() {
        Product product = new TaxFreeProduct("book", Dollar.valueOf(1.01));
        Money actualMoney = product.getCost();

        assertEquals(1.01, actualMoney.doubleValue());
    }

    @Test
    @DisplayName("given null parameters, when creating a product, return a NullPointerException")
    void givenNullValue_whenCreatingAProduct_returnANullPointerException() {
        assertThrows(NullPointerException.class, () -> new TaxFreeProduct(null, null));
    }
}