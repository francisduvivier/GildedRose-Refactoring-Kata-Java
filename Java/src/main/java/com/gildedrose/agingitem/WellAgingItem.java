package com.gildedrose.agingitem;

public class WellAgingItem extends ExpiringItem {
    public WellAgingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseAge() {
        super.increaseAge();
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
