package com.gildedrose.agingitem;

public class TicketItem extends AgingItem {
    public TicketItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseAge() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
            if (this.sellIn < 11) {
                if (this.quality < 50) {
                    this.quality = this.quality + 1;
                }
            }

            if (this.sellIn < 6) {
                if (this.quality < 50) {
                    this.quality = this.quality + 1;
                }
            }
        }

        this.sellIn = this.sellIn - 1;

        if (this.sellIn < 0) {
            this.quality = 0;
        }
    }
}
