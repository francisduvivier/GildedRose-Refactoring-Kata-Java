package com.gildedrose.agingitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiringItemTest {

    private static class ExpiringItemImpl extends ExpiringItem {
        public ExpiringItemImpl(String name, int sellIn, int quality) {
            super(name, sellIn, quality);
        }
    }

    /**
     * At the end of each day our system lowers sell in.
     */
    @Test
    public void decreasesQualityByOneWhenAgesBeforeExpiry() {
        int startSellIn = 10;
        ExpiringItemImpl item = new ExpiringItemImpl("Expiring Item", startSellIn, 20);

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
        ExpiringItemImpl item = new ExpiringItemImpl("Expiring Item", startSellIn, startQuality);

        int amountOverSellin = 1;
        for (int i = 0; i < startSellIn + amountOverSellin; i++) {
            item.increaseAge();
        }

        assertEquals(-amountOverSellin, item.sellIn);
    }
}
