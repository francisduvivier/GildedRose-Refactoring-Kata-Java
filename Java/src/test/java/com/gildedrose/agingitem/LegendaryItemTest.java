package com.gildedrose.agingitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LegendaryItemTest {
    /**
     * Being a legendary item, never has to be sold or decreases in Quality
     */
    @Test
    public void keepsQualityWhenAgesBeforeExpiry() {
        int startQuality = 20;
        LegendaryItem item = new LegendaryItem("Aged Brie", 10, startQuality);

        item.increaseAge();

        assertEquals(startQuality, item.quality);
    }

    /**
     * Edge case test for:
     * being a legendary item, never has to be sold or decreases in Quality
     */
    @Test
    public void keepsQualityWhenAgesRightBeforeSellIn() {
        int startQuality = 20;
        int startSellIn = 10;
        LegendaryItem item = new LegendaryItem("general", startSellIn, startQuality);

        for (int i = 0; i < startSellIn; i++) {
            item.increaseAge();
        }

        assertEquals(startQuality, item.quality);
    }

    /**
     * Edge case: Doesn't change quality when increasing age by a lot
     */
    @Test
    public void neverIncreasesQuality() {
        int startQuality = 45;
        int startSellIn = 10;
        LegendaryItem item = new LegendaryItem("general", startSellIn, startQuality);

        int amountToAge = 55 - startQuality;
        for (int i = 0; i < amountToAge; i++) {
            item.increaseAge();
        }

        assertEquals(startQuality, item.quality);
    }
}
