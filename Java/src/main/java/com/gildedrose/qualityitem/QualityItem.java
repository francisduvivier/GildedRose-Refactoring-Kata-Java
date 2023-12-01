package com.gildedrose.qualityitem;

import com.gildedrose.Item;

public class QualityItem {
    private Item item;

    public QualityItem(String name, int sellIn, int quality) {
        item = new Item(name, sellIn, quality);
    }

    public int getQuality() {
        return this.item.quality;
    }
}
