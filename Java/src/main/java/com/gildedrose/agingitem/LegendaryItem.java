package com.gildedrose.agingitem;

public class LegendaryItem extends AgingItem {
    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseAge() {
        // Being a legendary item, never has to be sold or decreases in Quality
    }
}
