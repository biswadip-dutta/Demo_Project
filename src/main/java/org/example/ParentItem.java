package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParentItem extends Item{
    List<Item> children = new ArrayList<>();

    public ParentItem(String name, BigDecimal value, boolean calculated) {
        super(name, value, calculated);
    }
}