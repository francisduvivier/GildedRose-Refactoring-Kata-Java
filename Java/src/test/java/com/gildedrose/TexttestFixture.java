package com.gildedrose;

import com.gildedrose.agingitem.*;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        //noinspection deprecation
        LegendaryItem legendaryItemWithNegativeSellIn = new LegendaryItem("Sulfuras, Hand of Ragnaros", -1, 80);
        AgingItem[] items = new AgingItem[]{
            new DegradingItem("+5 Dexterity Vest", 10, 20), //
            new WellAgingItem("Aged Brie", 2, 0), //
            new DegradingItem("Elixir of the Mongoose", 5, 7), //
            new LegendaryItem("Sulfuras, Hand of Ragnaros", 80), //
            legendaryItemWithNegativeSellIn,
            new TicketItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new TicketItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new TicketItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new DegradingItem("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
