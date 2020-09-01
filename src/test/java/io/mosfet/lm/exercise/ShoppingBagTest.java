package io.mosfet.lm.exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingBagTest {

    @Test
    @DisplayName("given a bag with two equal product, when getting product descriptions, return the right quantity")
    void givenABagWithSameProduct_whenGettingProductDescriptions_returnTheRightQuantity() {
        ShoppingBag shoppingBag = new ShoppingBag.Builder()
                .add(new TaxFreeProduct("book", 12.49))
                .add(new TaxFreeProduct("book", 12.49))
                .build();

        String productDescriptions = shoppingBag.getProductDescriptions();

        String expectedProducts = "2 book:";
        assertTrue(productDescriptions.contains(expectedProducts));
    }
}