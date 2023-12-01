package com.gildedrose;

import com.gildedrose.agingitem.AgingItem;

class GildedRose {
    AgingItem[] items;

    public GildedRose(AgingItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i].increaseAge(1);
        }
    }
}
