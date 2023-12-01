package com.gildedrose.qualityitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QualityItemTest {

    @Test
    public void ItemQualityIsAccessible() {
        QualityItem item = new QualityItem("general", 10, 20);
        assertEquals(20, item.getQuality());
    }

}
