package io.mosfet.lm.exercise;

public interface Bag {
    String getProductDescriptions();

    Item getItem(int index);

    boolean isEmpty();
}
