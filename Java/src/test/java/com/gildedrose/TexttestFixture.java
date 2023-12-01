package com.gildedrose;

import com.gildedrose.agingitem.AgingItem;
import com.gildedrose.agingitem.CustomAgingItem;
import com.gildedrose.agingitem.StandardAgingItem;
import com.gildedrose.agingitem.WellAgingItem;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        AgingItem[] items = new AgingItem[]{
            new StandardAgingItem("+5 Dexterity Vest", 10, 20), //
            new WellAgingItem("Aged Brie", 2, 0), //
            new CustomAgingItem("Elixir of the Mongoose", 5, 7), //
            new CustomAgingItem("Sulfuras, Hand of Ragnaros", 0, 80), //
            new CustomAgingItem("Sulfuras, Hand of Ragnaros", -1, 80),
            new CustomAgingItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new CustomAgingItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new CustomAgingItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new StandardAgingItem("Conjured Mana Cake", 3, 6)};

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
