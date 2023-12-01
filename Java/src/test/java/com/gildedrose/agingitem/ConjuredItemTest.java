package com.gildedrose.agingitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * "Conjured" items degrade in Quality twice as fast as normal items
 */
public class ConjuredItemTest {

    /**
     * At the end of each day our system lowers both values for every item
     */
    @Test
    public void decreasesQualityByTwoWhenAgesBeforeExpiry() {
        int startQuality = 20;
        ConjuredItem item = new ConjuredItem("conjured", 10, startQuality);

        item.increaseAge();

        assertEquals(startQuality - 2, item.quality);
    }

    /**
     * Edge case test for:
     * At the end of each day our system lowers both values for every item
     */
    @Test
    public void decreasesQualityByTwoWhenAgesRightBeforeExpiry() {
        int startQuality = 40;
        int startSellIn = 10;
        ConjuredItem item = new ConjuredItem("conjured", startSellIn, startQuality);

        for (int i = 0; i < startSellIn; i++) {
            item.increaseAge();
        }

        assertEquals(startQuality - startSellIn * 2, item.quality);
    }

    /**
     * The Quality of an item is never negative
     */
    @Test
    public void neverDecreasesQualityBelowZero() {
        int startQuality = 40;
        int startSellIn = 10;
        ConjuredItem item = new ConjuredItem("conjured", startSellIn, startQuality);

        for (int i = 0; i < startQuality + 10; i++) {
            item.increaseAge();
        }

        assertEquals(0, item.quality);
    }

    /**
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    @Test
    public void decreaseQualityAtDoubleSpeedWhenSellInHasPassed() {
        int startQuality = 50;
        int startSellIn = 10;
        ConjuredItem item = new ConjuredItem("conjured", startSellIn, startQuality);

        int extraAgeAfterSellInPassed = 3;
        for (int i = 0; i < startSellIn + extraAgeAfterSellInPassed; i++) {
            item.increaseAge();
        }

        int expectedQuality = startQuality - 2 * (startSellIn + 2 * extraAgeAfterSellInPassed);
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
        ConjuredItem item = new ConjuredItem("conjured", startSellIn, startQuality);

        int minimalDaysToZeroAfterSellInPassed = (int) Math.ceil((startQuality - startSellIn) / 4.0);
        for (int i = 0; i < startSellIn / 2 + minimalDaysToZeroAfterSellInPassed; i++) {
            item.increaseAge();
        }

        assertEquals(0, item.quality);
    }
}
