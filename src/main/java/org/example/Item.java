package org.example;

import java.math.BigDecimal;

public class Item {
    String name;
    BigDecimal value;
    boolean calculated;

    public Item(String name, BigDecimal value, boolean calculated) {
        this.name = name;
        this.value = value;
        this.calculated = calculated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public boolean isCalculated() {
        return calculated;
    }

    public void setCalculated(boolean calculated) {
        this.calculated = calculated;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", calculated=" + calculated +
                '}';
    }
}