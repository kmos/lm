package io.mosfet.lm.exercise.cash;

import java.math.BigDecimal;

public interface Money {

    double asDouble();

    Money add(Money money);

    BigDecimal asBigDecimal();

    Money multiply(Integer value);
}
