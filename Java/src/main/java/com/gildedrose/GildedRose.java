package com.gildedrose;

import com.gildedrose.agingitem.AgingItem;

class GildedRose {
    AgingItem[] items;

    public GildedRose(AgingItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (AgingItem item : items) {
            item.increaseAge();
        }
    }
}
