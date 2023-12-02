package com.gildedrose.agingitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WellAgingItemTest extends ExpiringItemTest {
    /**
     * At the end of each day our system lowers both values for every item
     */
    @Test
    public void increasesQualityByOneWhenAgesBeforeExpiry() {
        int startQuality = 20;
        WellAgingItem item = new WellAgingItem("Aged Brie", 10, startQuality);

        item.increaseAge();

        assertEquals(startQuality + 1, item.quality);
    }

    /**
     * Edge case test for:
     * At the end of each day our system lowers both values for every item
     */
    @Test
    public void increasesQualityByOneWhenAgesRightBeforeSellIn() {
        int startQuality = 20;
        int startSellIn = 10;
        WellAgingItem item = new WellAgingItem("general", startSellIn, startQuality);

        for (int i = 0; i < startSellIn; i++) {
            item.increaseAge();
        }

        assertEquals(startQuality + startSellIn, item.quality);
    }

    /**
     * The Quality of an item is never over 50
     */
    @Test
    public void neverIncreasesQualityAbove50() {
        int startQuality = 45;
        int startSellIn = 10;
        WellAgingItem item = new WellAgingItem("general", startSellIn, startQuality);

        int amountToAge = 55 - startQuality;
        for (int i = 0; i < amountToAge; i++) {
            item.increaseAge();
        }

        assertEquals(50, item.quality);
    }

    /**
     * Once the sell by date has passed, Quality increases twice as fast
     */
    @Test
    public void increaseQualityAtDoubleSpeedWhenSellInHasPassed() {
        int startQuality = 20;
        int startSellIn = 10;
        WellAgingItem item = new WellAgingItem("general", startSellIn, startQuality);

        int extraAgeAfterSellInPassed = 3;
        for (int i = 0; i < startSellIn + extraAgeAfterSellInPassed; i++) {
            item.increaseAge();
        }

        int expectedQuality = startQuality + (startSellIn + 2 * extraAgeAfterSellInPassed);
        assertEquals(expectedQuality, item.quality);
    }


    /**
     * Edge case test for:
     * Once the sell by date has passed, Quality increases twice as fast
     */
    @Test
    public void increaseQualityAtDoubleSpeedTo50WhenSellInHasPassed() {
        int startQuality = 41;
        int startSellIn = 10;
        WellAgingItem item = new WellAgingItem("general", startSellIn, startQuality);

        int minimalDaysToZeroAfterSellInPassed = (int) Math.ceil((startQuality - startSellIn) / 2.0);
        for (int i = 0; i < startSellIn + minimalDaysToZeroAfterSellInPassed; i++) {
            item.increaseAge();
        }

        assertEquals(50, item.quality);
    }

    @Override
    protected AgingItem createItem(String name, int sellIn, int quality) {
        return new WellAgingItem(name, sellIn, quality);
    }
}
