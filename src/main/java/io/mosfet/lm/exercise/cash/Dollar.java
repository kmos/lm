package io.mosfet.lm.exercise.cash;

import java.util.Objects;

public class Dollar implements Money {
    private final double value;

    public Dollar(double value) {
        this.value = value;
    }

    public static Money from(double value) {
        return new Dollar(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dollar dollar = (Dollar) o;
        return Double.compare(dollar.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public double get() {
        return value;
    }
}
