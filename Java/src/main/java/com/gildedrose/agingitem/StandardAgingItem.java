package com.gildedrose.agingitem;

public class StandardAgingItem extends AgingItem {
    public StandardAgingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseAge(int amount) {
        this.sellIn--;
        if (this.quality == 0) {
            return;
        }
        this.quality -= amount;
        int amountOverExpiry = amount - (Math.max(0, this.sellIn + 1));
        if (amountOverExpiry > 0) {
            // The amount of time that goes over the expiry is counted double
            this.quality -= amountOverExpiry;
        }
        // Make sure minimum quality is 0
        if (this.quality < 0) {
            this.quality = 0;
        }
    }
}
