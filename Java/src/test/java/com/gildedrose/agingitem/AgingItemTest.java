package com.gildedrose.agingitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgingItemTest {

    @Test
    public void itemQualityIsAccessible() {
        AgingItem item = new AgingItem("general", 10, 20);
        assertEquals(20, item.getQuality());
    }

}
