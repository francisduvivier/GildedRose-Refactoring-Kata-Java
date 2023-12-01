package com.gildedrose.agingitem;

public class WellAgingItem extends AgingItem {
    private static int MAX_ITEM_QUALITY = 50;

    public WellAgingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseAge() {
        this.sellIn--;
        if (this.quality >= MAX_ITEM_QUALITY) {
            return;
        }
        this.quality = this.quality + 1;
        if (this.quality >= MAX_ITEM_QUALITY) {
            return;
        }
        if (this.sellIn < 0) {
            this.quality = this.quality + 1;
        }
    }
}
