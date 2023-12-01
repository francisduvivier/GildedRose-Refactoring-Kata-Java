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
        this.item.sellIn--;
        if (this.item.quality == 0) {
            return;
        }
        this.item.quality -= amount;
        int amountOverExpiry = amount - (this.item.sellIn + 1);
        if (amountOverExpiry > 0) {
            // The amount of time that goes over the expiry is counted double
            this.item.quality -= amountOverExpiry;
        }
        // Make sure minimum quality is 0
        if (this.item.quality < 0) {
            this.item.quality = 0;
        }
    }
}
