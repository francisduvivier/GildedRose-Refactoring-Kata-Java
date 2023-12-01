package com.gildedrose.agingitem;

public class StandardAgingItem extends AgingItem {
    public StandardAgingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseAge() {
        this.sellIn--;
        if (this.quality == 0) {
            return;
        }
        this.quality--;

        if (this.quality > 0 && // Ensure quality does not go below 0
            this.sellIn < 0) {
            // The amount of time that goes over the expiry is counted double
            this.quality--;
        }
    }
}
