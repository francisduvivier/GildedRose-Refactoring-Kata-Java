package com.gildedrose.agingitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ExpiringItemTest extends AgingItemsTest {

    /**
     * At the end of each day our system lowers sell in.
     */
    @Test
    public void decreasesQualityByOneWhenAgesBeforeExpiry() {
        int startSellIn = 10;
        AgingItem item = createItem("Expiring Item", startSellIn, 20);

        item.increaseAge();

        assertEquals(startSellIn - 1, item.sellIn);
    }

    /**
     * Edge case test with negative sell in for:
     * At the end of each day our system lowers sell in.
     */
    @Test
    public void decreasesQualityByOneWhenAgesRightBeforeExpiry() {
        int startQuality = 20;
        int startSellIn = 10;
        AgingItem item = createItem("Expiring Item", startSellIn, startQuality);

        int amountOverSellin = 1;
        for (int i = 0; i < startSellIn + amountOverSellin; i++) {
            item.increaseAge();
        }

        assertEquals(-amountOverSellin, item.sellIn);
    }
}
