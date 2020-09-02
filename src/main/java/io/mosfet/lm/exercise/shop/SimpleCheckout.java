package io.mosfet.lm.exercise.shop;

public class SimpleCheckout implements Checkout {

    private final Bag bag;

    public SimpleCheckout(Bag bag) {
        this.bag = bag;
    }

    @Override
    public String getSummary() {

        if (bag != null && !bag.isEmpty()) {
            return  bag.getProductDescriptions() + "\n" +
                    "Sales Taxes: 0\n" +
                    "Total: 28.98\n";
        }

        return "your bag is empty! Please fill it before checkout";
    }
}
