package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
    @Test
    public void qualityAndSellInDecreasesAtTheEndOfTheDay () {
        Item[] items = new Item[] { new Item("foo", 1, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(19, gildedRose.items[0].quality);
        assertEquals(0, gildedRose.items[0].sellIn);
    }

    @Test
    public void qualityDecreasesTwiceFasterWhenSellInHasPassed () {
        Item[] items = new Item[] { new Item("foo", 0, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(18, gildedRose.items[0].quality);
    }

    @Test
    public void qualityIsNeverNegative () {
        Item[] items = new Item[] { new Item("foo", 0, 1) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void qualityOfAgedBrieIncreasesWhenGettingOlder () {
        Item[] items = new Item[] {
                new Item("Aged Brie", 1, 1),
                new Item("Aged Brie", 0, 1)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(2, gildedRose.items[0].quality);
        assertEquals(3, gildedRose.items[1].quality);
    }

    @Test
    public void qualityIsNeverGreaterThanFifty () {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    public void sulfurasIsNeverSold () {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 50) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(1, gildedRose.items[0].sellIn);
    }

    @Test
    public void sulfurasQualityNeverDecrease () {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 50) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    public void backstagePassesQualityIncreaseWhenSellInDecrease () {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    public void backstagePassesQualityIncreaseTwiceFasterWhenSellInLowerOrEqualThanTen () {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(3, gildedRose.items[0].quality);
        assertEquals(12, gildedRose.items[1].quality);
    }

    @Test
    public void backstagePassesQualityIncreaseThreeTimesFasterWhenSellInLowerOrEqualThanFive () {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(4, gildedRose.items[0].quality);
        assertEquals(13, gildedRose.items[1].quality);
    }

    @Test
    public void backstagePassesQualityDropsToZeroWhenSellInLowerOrEqualThanZero () {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }
}
