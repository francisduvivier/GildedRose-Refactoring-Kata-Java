package com.gildedrose.agingitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketItemTest {
    /**
     * Quality increases by 2 when there are 10 days or less
     */
    @Test
    public void increasesQualityBy2WhenAges10DaysBeforeExpiry() {
        int startQuality = 20;
        TicketItem item = new TicketItem("Aged Brie", 10, startQuality);

        item.increaseAge();

        assertEquals(startQuality + 2, item.quality);
    }

    /**
     * Edge case for:
     * Quality increases by 2 when there are 10 days or less
     */
    @Test
    public void increasesQualityBy2WhenAges6DaysBeforeExpiry() {
        int startQuality = 20;
        TicketItem item = new TicketItem("Aged Brie", 6, startQuality);

        item.increaseAge();

        assertEquals(startQuality + 2, item.quality);
    }

    /**
     * Quality increases by 3 when there are 5 days or less
     */
    @Test
    public void increasesQualityBy3WhenAges5DaysBeforeExpiry() {
        int startQuality = 20;
        TicketItem item = new TicketItem("Aged Brie", 5, startQuality);

        item.increaseAge();

        assertEquals(startQuality + 3, item.quality);
    }

    /**
     * Edge case for:
     * Quality increases by 3 when there are 5 days or less
     */
    @Test
    public void increasesQualityBy3WhenAges1DayBeforeExpiry() {
        int startQuality = 20;
        TicketItem item = new TicketItem("Aged Brie", 1, startQuality);

        item.increaseAge();

        assertEquals(startQuality + 3, item.quality);
    }

    /**
     * Edge case for:
     * Quality drops to 0 after the concert
     */
    @Test
    public void dropsQualityTo0WhenPastExpiry() {
        int startQuality = 20;
        int sellIn = 5;
        TicketItem item = new TicketItem("Aged Brie", sellIn, startQuality);
        for (int i = 0; i < sellIn + 5; i++) {
            item.increaseAge();
        }
        assertEquals(0, item.quality);
    }

    /**
     * Edge case for:
     * Quality drops to 0 after the concert
     */
    @Test
    public void dropsQualityTo0WhenJustPastExpiry() {
        int startQuality = 20;
        int sellIn = 5;
        TicketItem item = new TicketItem("Aged Brie", sellIn, startQuality);

        for (int i = 0; i < sellIn + 1; i++) {
            item.increaseAge();
        }
        assertEquals(0, item.quality);
    }
}
