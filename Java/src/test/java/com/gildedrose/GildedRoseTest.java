package com.gildedrose;

import com.gildedrose.agingitem.AgingItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void keepsItems() {
        AgingItem[] items = new AgingItem[]{
            new SpiedUponAgingItem("foo", 0, 0),
            new SpiedUponAgingItem("bar", 0, 0),
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items, app.items);
    }

    @Test
    void callsIncreaseAgeOnEveryItemWhenCallingUpdateQuality() {
        SpiedUponAgingItem spy = new SpiedUponAgingItem("foo", 0, 0);
        AgingItem[] items = new AgingItem[]{spy};
        GildedRose app = new GildedRose(items);

        int updateCalls = 3;
        for (int i = 0; i < updateCalls; i++) {
            app.updateQuality();
        }

        assertEquals(spy.totalAgeIncrease, updateCalls);
    }

    private static class SpiedUponAgingItem extends AgingItem {
        int totalAgeIncrease = 0;

        public SpiedUponAgingItem(String name, int sellIn, int quality) {
            super(name, sellIn, quality);
        }

        @Override
        public void increaseAge() {
            totalAgeIncrease++;
        }
    }

}
