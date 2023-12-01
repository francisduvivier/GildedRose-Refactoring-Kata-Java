package com.gildedrose.agingitem;

public class CustomAgingItem extends AgingItem {
    public CustomAgingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void increaseAge() {
        if (!this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (this.quality > 0) {
                this.quality = this.quality - 1;
            }
        } else {
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
        }

        this.sellIn = this.sellIn - 1;

        if (this.sellIn < 0) {
            if (!this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (this.quality > 0) {
                    this.quality = this.quality - 1;
                }
            } else {
                this.quality = 0;
            }
        }
    }
}
