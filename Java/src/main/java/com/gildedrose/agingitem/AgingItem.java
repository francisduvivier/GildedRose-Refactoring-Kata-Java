package com.gildedrose.agingitem;

import com.gildedrose.Item;

public abstract class AgingItem extends Item {
    protected static final int MAX_ITEM_QUALITY = 50;

    public AgingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void increaseAge();
}
