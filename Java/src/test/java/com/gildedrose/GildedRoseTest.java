package com.gildedrose;

import com.gildedrose.agingitem.AgingItem;
import com.gildedrose.agingitem.StandardAgingItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        AgingItem[] items = new AgingItem[] { new StandardAgingItem("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

}
