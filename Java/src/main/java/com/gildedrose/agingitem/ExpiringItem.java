package com.gildedrose.agingitem;

public abstract class ExpiringItem extends AgingItem {
    public ExpiringItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseAge() {
        this.sellIn--;
    }
}
