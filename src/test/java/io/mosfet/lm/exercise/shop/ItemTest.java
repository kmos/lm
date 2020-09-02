package io.mosfet.lm.exercise.shop;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.products.BasicTaxedProduct;
import io.mosfet.lm.exercise.products.TaxFreeProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    @DisplayName("given an item of two, when getting the total, return it")
    void givenAnItemOfTwo_whenGettingTheTotal_returnIt() {
        Item actualItem = new Item(new TaxFreeProduct("book", Dollar.valueOf(1.02)), 2);

        assertEquals(Dollar.valueOf(2.04), actualItem.getTotal());
    }

    @Test
    @DisplayName("given an item of one, when getting the total, return it")
    void givenAnItemOfOne_whenGettingTheTotal_returnIt() {
        Item actualItem = new Item(new TaxFreeProduct("book", Dollar.valueOf(1.02)), 1);

        assertEquals(Dollar.valueOf(1.02), actualItem.getTotal());
    }

    @Test
    @DisplayName("given a taxed item, when getting the taxes, return it")
    void givenATaxedItemLikePerfume_whenGettingTheTaxes_returnIt() {
        Item actualItem = new Item(new BasicTaxedProduct(new TaxFreeProduct("perfume", Dollar.valueOf(10.02))), 1);

        assertTrue(actualItem.getTaxes().isPresent());
        assertEquals(Dollar.valueOf(1.0), actualItem.getTaxes().get());
    }

    @Test
    @DisplayName("given a taxed item, when getting the taxes, return it")
    void givenATaxedItemLikeMusicCD_whenGettingTheTaxes_returnIt() {
        Item actualItem = new Item(new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(20.02))), 1);

        assertTrue(actualItem.getTaxes().isPresent());
        assertEquals(Dollar.valueOf(2.0), actualItem.getTaxes().get());
    }

    @Test
    @DisplayName("given a not taxed item, when getting the taxes, return it")
    void givenANotTaxedItemLikeMilk_whenGettingTheTaxes_returnIt() {
        Item actualItem = new Item(new TaxFreeProduct("milk", Dollar.valueOf(1.02)), 1);

        assertFalse(actualItem.getTaxes().isPresent());
    }


}