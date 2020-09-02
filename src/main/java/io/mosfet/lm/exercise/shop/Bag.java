package io.mosfet.lm.exercise.shop;

public interface Bag {
    String getProductDescriptions();

    Item getItem(int index);

    boolean isEmpty();
}
