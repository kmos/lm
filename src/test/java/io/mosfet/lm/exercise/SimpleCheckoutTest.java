package io.mosfet.lm.exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCheckoutTest {

    @Test
    @DisplayName("given an empty bag, when getting the summary, then return a courtesy message")
    void givenAnEmptyBag_whenGettingTheSummary_thenReturnACourtesyMessage() {
        Product product = new TaxFreeProduct();
        Checkout checkout = new SimpleCheckout(new ShoppingBag(product));

        String actualSummary = checkout.getSummary();

        assertEquals("your bag is empty! Please fill it before checkout", actualSummary);
    }

    @Test
    @DisplayName("given a bag with a tax free product, when getting the summary, then return is description and Quantity")
    void givenABagWithATaxFreeProduct_whenGettingTheSummary_thenReturnIsDescriptionQuantityAndTotal() {
        Product product = new TaxFreeProduct();
        Checkout checkout = new SimpleCheckout(new ShoppingBag(product));

        String actualSummary = checkout.getSummary();

        String expectedSummary =
                        "1 book : 12.49\n" +
                        "Sales Taxes: 0\n" +
                        "Total: 12.49\n";
        assertEquals(expectedSummary, actualSummary);
    }
}