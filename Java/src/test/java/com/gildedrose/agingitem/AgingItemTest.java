package com.gildedrose.agingitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgingItemTest {

    /**
     * All items have a Quality value which denotes how valuable the item is
     */
    @Test
    public void qualityIsAccessible() {
        AgingItem item = new AgingItem("general", 10, 20);
        assertEquals(20, item.getQuality());
    }

    /**
     * At the end of each day our system lowers both values for every item
     */
    @Test
    public void decreasesQualityByOneWhenAgesBeforeExpiry() {
        int startQuality = 20;
        AgingItem item = new AgingItem("general", 10, startQuality);

        item.increaseAge(1);

        assertEquals(startQuality - 1, item.getQuality());
    }

    /**
     * Edge case test for:
     * At the end of each day our system lowers both values for every item
     */
    @Test
    public void decreasesQualityByOneWhenAgesRightBeforeExpiry() {
        int startQuality = 20;
        int startSellIn = 10;
        AgingItem item = new AgingItem("general", startSellIn, startQuality);

        item.increaseAge(startSellIn);

        assertEquals(startQuality - startSellIn, item.getQuality());
    }

    /**
     * The Quality of an item is never negative
     */
    @Test
    public void neverDecreasesQualityBelowZero() {
        int startQuality = 20;
        int startSellIn = 10;
        AgingItem item = new AgingItem("general", startSellIn, startQuality);

        item.increaseAge(startQuality + 10);

        assertEquals(0, item.getQuality());
    }

    /**
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    @Test
    public void decreaseQualityAtDoubleSpeedWhenSellInHasPassed() {
        int startQuality = 20;
        int startSellIn = 10;
        AgingItem item = new AgingItem("general", startSellIn, startQuality);

        int extraAgeAfterSellInPassed = 3;
        item.increaseAge(startSellIn + extraAgeAfterSellInPassed);

        int expectedQuality = startQuality - (startSellIn + 2 * extraAgeAfterSellInPassed);
        assertEquals(expectedQuality, item.getQuality());
    }


    /**
     * Edge case test for:
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    @Test
    public void decreaseQualityAtDoubleSpeedToZeroWhenSellInHasPassed() {
        int startQuality = 19;
        int startSellIn = 10;
        AgingItem item = new AgingItem("general", startSellIn, startQuality);

        int minimalDaysToZeroAfterSellInPassed = (int) Math.ceil((startQuality - startSellIn) / 2.0);
        item.increaseAge(startSellIn + minimalDaysToZeroAfterSellInPassed);

        assertEquals(0, item.getQuality());
    }
}
