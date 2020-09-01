package io.mosfet.lm.exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcceptanceTest {

    @Test
    @DisplayName("given a set of products with one taxed, when getting the summary during checkout process, then return descriptions taxes and total")
    void givenASetProductsWithOneTaxed_whenGettingTheSummaryCheckout_thenReturnDescriptionsTaxesAndTotal() {
        Product product = new TaxFreeProduct();
        Checkout checkout = new SimpleCheckout(new ShoppingBag(product));

        String actualSummary = checkout.getSummary();

        String expectedSummary =
                "1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83\n";
        assertEquals(expectedSummary, actualSummary);

    }
}