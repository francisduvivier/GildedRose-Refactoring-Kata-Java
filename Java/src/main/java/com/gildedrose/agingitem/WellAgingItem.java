package com.gildedrose.agingitem;

public class WellAgingItem extends AgingItem {
    public WellAgingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseAge() {
        this.sellIn--;
        if (this.quality >= 50) {
            return;
        }
        this.quality = this.quality + 1;

        if (this.sellIn < 0) {
            this.quality = this.quality + 1;
        }
        if (this.quality > 50) {
            this.quality = 50;
        }
    }
}
