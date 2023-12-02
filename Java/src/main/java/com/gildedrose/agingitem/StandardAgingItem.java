package com.gildedrose.agingitem;

public class StandardAgingItem extends ExpiringItem {
    private final int qualityUpdateMultiplier;

    public StandardAgingItem(String name, int sellIn, int quality) {
        this(name, sellIn, quality, 1);
    }

    protected StandardAgingItem(String name, int sellIn, int quality, int qualityUpdateMultiplier) {
        super(name, sellIn, quality);
        this.qualityUpdateMultiplier = qualityUpdateMultiplier;
    }

    @Override
    public void increaseAge() {
        super.increaseAge();
        if (this.quality == 0) {
            return;
        }
        this.quality -= qualityUpdateMultiplier;

        if (this.sellIn < 0) {
            // The amount of time that goes over the expiry is counted double
            this.quality -= qualityUpdateMultiplier;
        }
        if (this.quality < 0) {
            this.quality = 0;
        }
    }
}
