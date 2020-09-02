package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicTaxedProductTest {

    @Test
    @DisplayName("given a basic taxed product, when getting the cost, return it taxed")
    void givenBasicTaxedProduct_whenGettingTheCost_returnItTaxed() {
        TaxedProduct actualTaxedProduct = new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(14.99)));

        assertEquals(Dollar.valueOf(16.49), actualTaxedProduct.getCost());
    }
}