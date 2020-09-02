package io.mosfet.lm.exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingBagTest {

    @Test
    @DisplayName("given a bag with two equal product, when getting an item, return the right quantity and product")
    void givenABagWithSameProduct_whenGettingProductDescriptions_returnTheRightQuantity() {
        TaxFreeProduct book = new TaxFreeProduct("book", 12.49);
        ShoppingBag shoppingBag = new ShoppingBag.Builder()
                .add(book)
                .add(book)
                .build();

        Item actualItem = shoppingBag.getItem(0);

        assertEquals(book, actualItem.getProduct());
        assertEquals(2, actualItem.getQuantity().intValue());
    }
}