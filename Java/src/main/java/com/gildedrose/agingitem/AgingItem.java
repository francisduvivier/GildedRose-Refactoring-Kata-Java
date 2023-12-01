package com.gildedrose.agingitem;

import com.gildedrose.Item;

public abstract class AgingItem extends Item {

    public AgingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void increaseAge(int amount) ;
}
