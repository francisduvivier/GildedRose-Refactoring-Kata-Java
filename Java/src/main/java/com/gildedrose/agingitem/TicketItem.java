package com.gildedrose.agingitem;

public class TicketItem extends AgingItem {
    public TicketItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseAge() {
        this.sellIn--;
        if (this.sellIn < 0) {
            this.quality = 0;
            return;
        }
        if (this.quality >= MAX_ITEM_QUALITY) {
            return;
        }
        this.quality = this.quality + 1;
        if (this.quality >= MAX_ITEM_QUALITY) {
            return;
        }
        if (this.sellIn < 10) {
            this.quality = this.quality + 1;
            if (this.quality >= MAX_ITEM_QUALITY) {
                return;
            }
        }
        if (this.sellIn < 5) {
            this.quality = this.quality + 1;
        }
    }
}
