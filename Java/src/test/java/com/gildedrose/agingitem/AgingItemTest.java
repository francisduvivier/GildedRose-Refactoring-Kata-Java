package com.gildedrose.agingitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgingItemTest {

    @Test
    public void qualityIsAccessible() {
        AgingItem item = new AgingItem("general", 10, 20);
        assertEquals(20, item.getQuality());
    }

    @Test
    public void decreasesQualityByOneWhenAgesBeforeExpiry() {
        int startQuality = 20;
        AgingItem item = new AgingItem("general", 10, startQuality);

        item.increaseAge(1);
        assertEquals(startQuality - 1, item.getQuality());
    }

    @Test
    public void decreasesQualityByOneWhenAgesRightBeforeExpiry() {
        int startQuality = 20;
        int startSellIn = 10;
        AgingItem item = new AgingItem("general", startSellIn, startQuality);

        item.increaseAge(startSellIn);
        assertEquals(startQuality - startSellIn, item.getQuality());
    }
}
