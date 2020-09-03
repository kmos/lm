package io.mosfet.lm.exercise.products;

import io.mosfet.lm.exercise.cash.Dollar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("given a basic TaxedProduct")
class BasicTaxedProductTest {

    @Nested
    @DisplayName("when getting the cost")
    class WhenGettingCost {

        @Test
        @DisplayName("given a basic taxed product like music cd, when getting the cost, return it taxed")
        void givenBasicTaxedProductLikeMusicCD_whenGettingTheCost_thenReturnItTaxed() {
            Product actualTaxedProduct = new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(14.99)));

            assertEquals(Dollar.valueOf(16.49), actualTaxedProduct.getCost());
        }

        @Test
        @DisplayName("given a basic taxed product like perfume, when getting the cost, return it taxed")
        void givenBasicTaxedProductLikePerfume_whenGettingTheCost_thenReturnItTaxed() {
            Product actualTaxedProduct = new BasicTaxedProduct(new TaxFreeProduct("perfume", Dollar.valueOf(15.99)));

            assertEquals(Dollar.valueOf(17.59), actualTaxedProduct.getCost());
        }


    }

    @Nested
    @DisplayName("when getting taxes")
    class WhenGettingTaxes {

        @Test
        @DisplayName("given a basic taxed product like music CD, when getting the taxes, return it correctly")
        void givenBasicTaxedProductLikeMusicCD_whenGettingTaxes_thenReturnItCorrectly() {
            Product actualTaxedProduct = new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(15.99)));
            assertEquals(Dollar.valueOf(1.6), actualTaxedProduct.getTaxes());
        }

        @Test
        @DisplayName("given a basic taxed product like Perfume, when getting taxes, then return it correctly")
        void givenBasicTaxedProductLikePerfume_whenGettingTaxes_thenReturnItCorrectly() {
            Product actualTaxedProduct = new BasicTaxedProduct(new TaxFreeProduct("perfume", Dollar.valueOf(14.99)));
            assertEquals(Dollar.valueOf(1.5), actualTaxedProduct.getTaxes());
        }

        @Test
        @DisplayName("given a basic taxed product like pills, when getting taxes, then return it correctly")
        void givenBasicTaxedProductLikePills_whenGettingTaxes_thenReturnItCorrectly() {
            Product actualTaxedProduct = new BasicTaxedProduct(new TaxFreeProduct("pills", Dollar.valueOf(11.99)));
            assertEquals(Dollar.valueOf(1.2), actualTaxedProduct.getTaxes());
        }

    }

    @Nested
    @DisplayName("when asking for toString")
    class WhenAskingForToString {

        @Test
        @DisplayName("given a basi taxed product like music cd, when getting toString, then return it correctly")
        void givenBasicTaxedProductLikeMusicCD_whenAskingForToString_thenReturnItFormatted() {
            Product actualTaxedProduct = new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(15.99)));
            assertEquals("music CD: 17.59", actualTaxedProduct.toString());
        }

        @Test
        @DisplayName("given a basi taxed product like pills, when getting toString, then return it correctly")
        void givenBasicTaxedProductLikePills_whenAskingForToString_thenReturnItFormatted() {
            Product actualTaxedProduct = new BasicTaxedProduct(new TaxFreeProduct("pills", Dollar.valueOf(11.99)));
            assertEquals("pills: 13.19", actualTaxedProduct.toString());
        }

    }
}