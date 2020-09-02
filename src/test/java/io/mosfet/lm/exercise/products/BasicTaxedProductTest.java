package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicTaxedProductTest {

    @Test
    @DisplayName("given a basic taxed product like music cd, when getting the cost, return it taxed")
    void givenBasicTaxedProductLikeMusicCD_whenGettingTheCost_returnItTaxed() {
        TaxedProduct actualTaxedProduct = new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(14.99)));

        assertEquals(Dollar.valueOf(16.49), actualTaxedProduct.getCost());
    }

    @Test
    @DisplayName("given a basic taxed product like perfume, when getting the cost, return it taxed")
    void givenBasicTaxedProductLikePerfume_whenGettingTheCost_returnItTaxed() {
        TaxedProduct actualTaxedProduct = new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(15.99)));

        assertEquals(Dollar.valueOf(17.59), actualTaxedProduct.getCost());
    }
}