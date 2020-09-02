package io.mosfet.lm.exercise;

import io.mosfet.lm.exercise.cash.Dollar;
import io.mosfet.lm.exercise.products.TaxFreeProduct;
import io.mosfet.lm.exercise.shop.Checkout;
import io.mosfet.lm.exercise.shop.ShoppingBag;
import io.mosfet.lm.exercise.shop.SimpleCheckout;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcceptanceTest {

    @Test
    @DisplayName("given a set of products with one taxed, when getting the summary during checkout process, then return descriptions taxes and total")
    void givenASetProductsWithOneTaxed_whenGettingTheSummaryCheckout_thenReturnDescriptionsTaxesAndTotal() {
        Checkout checkout = new SimpleCheckout(new ShoppingBag.Builder()
                .add(new TaxFreeProduct("book", new Dollar(12.49)))
                .add(new TaxFreeProduct("music CD", new Dollar(16.49)))
                .add(new TaxFreeProduct("chocolate bar", new Dollar(0.85)))
                .build());

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