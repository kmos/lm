package io.mosfet.lm.exercise.shop;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.cash.Money;
import io.mosfet.lm.exercise.products.TaxFreeProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShoppingBagTest {

    @Test
    @DisplayName("given a bag with two equal product, when getting an item, return the right quantity and product")
    void givenABagWithSameProduct_whenGettingAnItem_returnTheRightQuantity() {
        TaxFreeProduct book = new TaxFreeProduct("book", Dollar.valueOf(12.49));
        Bag shoppingBag = new ShoppingBag.Builder()
                .add(book)
                .add(book)
                .build();

        Item actualItem = shoppingBag.getItem(0);

        assertEquals(book, actualItem.getProduct());
        assertEquals(2, actualItem.getQuantity().intValue());
    }

    @Test
    @DisplayName("given a bag with some products, when getting related items, return the right quantity and product")
    void givenABagWithSomeProduct_whenGettingThem_returnTheRightQuantity() {
        TaxFreeProduct book = new TaxFreeProduct("book", Dollar.valueOf(12.49));
        TaxFreeProduct chocolateBar = new TaxFreeProduct("chocolate bar", Dollar.valueOf(0.85));
        Bag shoppingBag = new ShoppingBag.Builder()
                .add(book)
                .add(book)
                .add(chocolateBar)
                .build();

        Item actualBookItem = shoppingBag.getItem(0);
        Item actualChocolateBarItem = shoppingBag.getItem(1);

        assertEquals(book, actualBookItem.getProduct());
        assertEquals(2, actualBookItem.getQuantity().intValue());
        assertEquals(chocolateBar, actualChocolateBarItem.getProduct());
        assertEquals(1, actualChocolateBarItem.getQuantity().intValue());
    }

    @Test
    @DisplayName("given a bag without products, when checking if it's filled, return empty")
    void givenABagWithoutProduct_whenCheckingIfFilled_returnEmpty() {
        Bag shoppingBag = new ShoppingBag.Builder()
                .build();

        assertTrue(shoppingBag.isEmpty());
    }

    @Test
    @DisplayName("given a bag with null values, when checking if it's filled, return empty")
    void givenABagWithNullValues_whenCheckingIfFilled_returnEmpty() {
        Bag shoppingBag = new ShoppingBag.Builder()
                .add(null)
                .add(null)
                .build();

        assertTrue(shoppingBag.isEmpty());
    }

    @Test
    @DisplayName("given a bag with two different products, when getting the total, return the right sum of them")
    void givenABagWithTwoProducts_whenGettingTheTotal_returnTheRightValue() {
        Bag shoppingBag = new ShoppingBag.Builder()
                .add(new TaxFreeProduct("book", Dollar.valueOf(1.1)))
                .add(new TaxFreeProduct("chocolate", Dollar.valueOf(1.3)))
                .build();

        Money actualTotal = shoppingBag.getTotal();

        assertEquals(Dollar.valueOf(1.4), actualTotal);
    }
}