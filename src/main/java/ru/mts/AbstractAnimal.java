package ru.mts;

import java.math.BigDecimal;

public abstract class AbstractAnimal implements Animal {
    protected String breed = "breedless";
    protected String name = "nameless";
    protected BigDecimal cost = new BigDecimal("0.00");
    protected String character = "characterless";
}
