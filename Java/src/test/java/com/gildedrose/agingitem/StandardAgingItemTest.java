package com.gildedrose.agingitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardAgingItemTest {

    /**
     * All items have a Quality value which denotes how valuable the item is
     */
    @Test
    public void qualityIsAccessible() {
        StandardAgingItem item = new StandardAgingItem("general", 10, 20);
        assertEquals(20, item.quality);
    }

    /**
     * At the end of each day our system lowers both values for every item
     */
    @Test
    public void decreasesQualityByOneWhenAgesBeforeExpiry() {
        int startQuality = 20;
        StandardAgingItem item = new StandardAgingItem("general", 10, startQuality);

        item.increaseAge(1);

        assertEquals(startQuality - 1, item.quality);
    }

    /**
     * Edge case test for:
     * At the end of each day our system lowers both values for every item
     */
    @Test
    public void decreasesQualityByOneWhenAgesRightBeforeExpiry() {
        int startQuality = 20;
        int startSellIn = 10;
        StandardAgingItem item = new StandardAgingItem("general", startSellIn, startQuality);

        item.increaseAge(startSellIn);

        assertEquals(startQuality - startSellIn, item.quality);
    }

    /**
     * The Quality of an item is never negative
     */
    @Test
    public void neverDecreasesQualityBelowZero() {
        int startQuality = 20;
        int startSellIn = 10;
        StandardAgingItem item = new StandardAgingItem("general", startSellIn, startQuality);

        item.increaseAge(startQuality + 10);

        assertEquals(0, item.quality);
    }

    /**
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    @Test
    public void decreaseQualityAtDoubleSpeedWhenSellInHasPassed() {
        int startQuality = 20;
        int startSellIn = 10;
        StandardAgingItem item = new StandardAgingItem("general", startSellIn, startQuality);

        int extraAgeAfterSellInPassed = 3;
        item.increaseAge(startSellIn + extraAgeAfterSellInPassed);

        int expectedQuality = startQuality - (startSellIn + 2 * extraAgeAfterSellInPassed);
        assertEquals(expectedQuality, item.quality);
    }

    /**
     * Test following with incremental aging
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    @Test
    public void withIncrementalAgingDecreaseQualityAtDoubleSpeedWhenSellInHasPassedAfterAlreadyPassed() {
        int startQuality = 20;
        int startSellIn = 10;
        StandardAgingItem item = new StandardAgingItem("general", startSellIn, startQuality);

        int extraAgeAfterSellInPassed = 3;
        for (int i = 0; i < startSellIn + extraAgeAfterSellInPassed; i++) {
            item.increaseAge(1);
        }

        int expectedQuality = startQuality - (startSellIn + 2 * extraAgeAfterSellInPassed);
        assertEquals(expectedQuality, item.quality);
    }


    /**
     * Edge case test for:
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    @Test
    public void decreaseQualityAtDoubleSpeedToZeroWhenSellInHasPassed() {
        int startQuality = 19;
        int startSellIn = 10;
        StandardAgingItem item = new StandardAgingItem("general", startSellIn, startQuality);

        int minimalDaysToZeroAfterSellInPassed = (int) Math.ceil((startQuality - startSellIn) / 2.0);
        item.increaseAge(startSellIn + minimalDaysToZeroAfterSellInPassed);

        assertEquals(0, item.quality);
    }
}
