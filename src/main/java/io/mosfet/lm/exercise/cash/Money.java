package io.mosfet.lm.exercise.cash;

public interface Money {
    double asDouble();

    Money add(Money money);
}
