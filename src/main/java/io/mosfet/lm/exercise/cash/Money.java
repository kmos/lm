package io.mosfet.lm.exercise.cash;

import java.math.BigDecimal;

public interface Money {

    double doubleValue();

    Money add(Money money);

    BigDecimal asBigDecimal();

    Money multiply(Integer value);

    Money multiply(BigDecimal value);

    Money getRoundingTo5Cents();
}
