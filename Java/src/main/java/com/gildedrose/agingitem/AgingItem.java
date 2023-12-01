package com.gildedrose.agingitem;

import com.gildedrose.Item;

public class AgingItem {
    private final Item item;

    public AgingItem(String name, int sellIn, int quality) {
        item = new Item(name, sellIn, quality);
    }

    public int getQuality() {
        return this.item.quality;
    }

    public void increaseAge(int amount) {
        for (int i = 0; i < amount; i++) {
            this.item.sellIn--;
            if (this.item.quality > 0) {
                if (this.item.sellIn >= 0 || this.item.quality == 1) {
                    this.item.quality -= 1;
                } else {
                    this.item.quality -= 2;
                }
            }
        }
    }
}
