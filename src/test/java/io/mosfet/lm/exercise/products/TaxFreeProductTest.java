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
        Product product = new TaxFreeProduct("book", new Dollar(1.01));
        Money actualMoney = product.getCost();

        assertEquals(1.01, actualMoney.get());
    }
}