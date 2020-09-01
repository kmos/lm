package io.mosfet.lm.exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCheckoutTest {

    @Test
    @DisplayName("given an empty bag, when getting the summary, then return a courtesy message")
    void givenAnEmptyBag_whenGettingTheSummary_thenReturnACourtesyMessage() {
        Checkout checkout = new SimpleCheckout();

        String actualSummary = checkout.getSummary();

        assertEquals("your bag is empty! Please fill it before checkout", checkout.getSummary());
    }
}