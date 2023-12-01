package com.gildedrose.agingitem;

import com.gildedrose.Item;

public class AgingItem {
    private Item item;

    public AgingItem(String name, int sellIn, int quality) {
        item = new Item(name, sellIn, quality);
    }

    public int getQuality() {
        return this.item.quality;
    }
}
