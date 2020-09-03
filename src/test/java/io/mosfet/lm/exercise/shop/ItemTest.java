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

        assertEquals(Dollar.valueOf(1.0), actualItem.getTaxes());
    }

    @Test
    @DisplayName("given a taxed item, when getting the taxes, return it")
    void givenATaxedItemLikeMusicCD_whenGettingTheTaxes_returnIt() {
        Item actualItem = new Item(new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(20.02))), 1);

        assertEquals(Dollar.valueOf(2.0), actualItem.getTaxes());
    }

    @Test
    @DisplayName("given a taxed product, when getting toString, return it formatted")
    void givenAProduct_whenGettingToString_returnItFormatted() {
        Item actualItem = new Item(new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(20.02))), 1);

        assertEquals("1 music CD: 22.02", actualItem.toString());
    }

    @Test
    @DisplayName("given a tax free product, when getting toString, return it formatted")
    void givenTwoProductTaxFree_whenGettingToString_returnItFormatted() {
        Item actualItem = new Item(new TaxFreeProduct("music CD", Dollar.valueOf(20.02)), 2);

        assertEquals("2 music CD: 40.04", actualItem.toString());
    }

    @Test
    @DisplayName("given two taxed product, when getting toString, return it formatted")
    void givenTwoProductTaxed_whenGettingToString_returnItFormatted() {
        Item actualItem = new Item(new BasicTaxedProduct(new TaxFreeProduct("music CD", Dollar.valueOf(20.02))), 2);

        assertEquals("2 music CD: 44.04", actualItem.toString());

    }
}