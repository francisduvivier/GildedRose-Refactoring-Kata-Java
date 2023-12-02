package com.gildedrose.agingitem;

public class LegendaryItem extends AgingItem {
    /**
     * @deprecated this constructor is deprecated, since sellIn is irrelevant for legendary items.
     * Please use the constructor without the sellIn parameter instead.
     */
    public LegendaryItem(String name, int sellIn,  int quality) {
        super(name, sellIn, quality);
    }

    public LegendaryItem(String name, int quality) {
        this(name, 0, quality);
    }

    @Override
    public void increaseAge() {
        // Being a legendary item, never has to be sold or decreases in Quality
    }
}
