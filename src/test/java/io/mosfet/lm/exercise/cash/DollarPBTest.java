package io.mosfet.lm.exercise.cash;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DollarPBTest {

    @Property
    void checkCommutativePropertyForSum(@ForAll @Positive BigDecimal a, @ForAll @Positive BigDecimal b) {
        Money aDollar = new Dollar(a);
        Money bDollar = new Dollar(b);
        assertEquals(aDollar.add(bDollar), bDollar.add(aDollar));
    }

    @Property
    void checkAssociativePropertyForSum(@ForAll @Positive BigDecimal a, @ForAll @Positive BigDecimal b, @ForAll @Positive BigDecimal c) {
        Money aDollar = new Dollar(a);
        Money bDollar = new Dollar(b);
        Money cDollar = new Dollar(c);
        assertEquals(aDollar.add(bDollar).add(cDollar), bDollar.add(cDollar).add(aDollar));
    }

}