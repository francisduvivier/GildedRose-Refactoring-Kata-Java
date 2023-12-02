package com.gildedrose.agingitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AgingItemsTest {

    protected abstract AgingItem createItem(String name, int sellIn, int quality);

    /**
     * All items have a SellIn value which denotes the number of days we have to sell the item
     */
    @Test
    public void sellInIsAccessible() {
        int givenSellIn = 10;
        AgingItem item = createItem("Test Item", givenSellIn, 20);

        assertEquals(givenSellIn, item.sellIn);
    }

    /**
     * All items have a Quality value which denotes how valuable the item is
     */
    @Test
    public void qualityIsAccessible() {
        int givenQuality = 20;
        AgingItem item = createItem("Test Item", 10, givenQuality);

        assertEquals(givenQuality, item.quality);
    }

    /**
     * Conforms to item stringification in order to make TextTest work
     */
    @Test
    public void hasCorrectStringification() {
        AgingItem item = createItem("Test Item", 10, 20);

        assertEquals("Test Item, 10, 20", item.toString());
    }
}
