package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
    private Item standardItem(int sellIn, int quality) {
        return new Item("foo", sellIn, quality);
    }

    private Item agedBrieItem(int sellIn, int quality) {
        return new Item("Aged Brie", sellIn, quality);
    }

    private Item sulfurasItem(int sellIn, int quality) {
        return new Item("Sulfuras, Hand of Ragnaros",  sellIn, quality);
    }

    private Item backstagePassesItem(int sellIn, int quality) {
        return new Item("Backstage passes to a TAFKAL80ETC concert",  sellIn, quality);
    }

    private GildedRose gildedRoseSelling(Item... items) {
        return new GildedRose(items);
    }

    @Test
    public void qualityAndSellInDecreasesAtTheEndOfTheDay () {
        GildedRose gildedRose = gildedRoseSelling(
                standardItem(1, 20)
        );

        gildedRose.updateQuality();

        assertEquals(19, gildedRose.items[0].quality);
        assertEquals(0, gildedRose.items[0].sellIn);
    }

    @Test
    public void qualityDecreasesTwiceFasterWhenSellInHasPassed () {
        GildedRose gildedRose = gildedRoseSelling(
                standardItem( 0, 20)
        );
        gildedRose.updateQuality();
        assertEquals(18, gildedRose.items[0].quality);
    }

    @Test
    public void qualityIsNeverNegative () {
        GildedRose gildedRose = gildedRoseSelling(
                standardItem( 0, 0)
        );
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void qualityOfAgedBrieIncreasesWhenGettingOlder () {
        GildedRose gildedRose = gildedRoseSelling(
                agedBrieItem(1, 1),
                agedBrieItem(0, 1),
                agedBrieItem(-1, 49),
                agedBrieItem(-1, 50)
        );
        gildedRose.updateQuality();
        assertEquals(2, gildedRose.items[0].quality);
        assertEquals(3, gildedRose.items[1].quality);
        assertEquals(50, gildedRose.items[2].quality);
        assertEquals(50, gildedRose.items[3].quality);
    }

    @Test
    public void qualityIsNeverGreaterThanFifty () {
        Item itemThatCanIncreaseInQuality = agedBrieItem(1, 50);
        GildedRose gildedRose = gildedRoseSelling(
                itemThatCanIncreaseInQuality
        );
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    public void sulfurasIsNeverSold () {
        GildedRose gildedRose = gildedRoseSelling(
                sulfurasItem( 1, 50)
        );
        gildedRose.updateQuality();
        assertEquals(1, gildedRose.items[0].sellIn);
    }

    @Test
    public void sulfurasQualityNeverDecrease () {
        GildedRose gildedRose = gildedRoseSelling(
                sulfurasItem(1, 50)
        );
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[0].quality);
    }

    @Test
    public void backstagePassesQualityIncreaseWhenSellInDecrease () {
        GildedRose gildedRose = gildedRoseSelling(
                backstagePassesItem(11, 1),
                backstagePassesItem(11, 49),
                backstagePassesItem(11, 50)
        );
        gildedRose.updateQuality();
        assertEquals(2, gildedRose.items[0].quality);
        assertEquals(50, gildedRose.items[1].quality);
        assertEquals(50, gildedRose.items[2].quality);
    }

    @Test
    public void backstagePassesQualityIncreaseTwiceFasterWhenSellInLowerOrEqualThanTen () {
        GildedRose gildedRose = gildedRoseSelling(
                backstagePassesItem(10, 1),
                backstagePassesItem(6, 10),
                backstagePassesItem(6, 49),
                backstagePassesItem(6, 50)
        );
        gildedRose.updateQuality();
        assertEquals(3, gildedRose.items[0].quality);
        assertEquals(12, gildedRose.items[1].quality);
        assertEquals(50, gildedRose.items[2].quality);
        assertEquals(50, gildedRose.items[3].quality);
    }

    @Test
    public void backstagePassesQualityIncreaseThreeTimesFasterWhenSellInLowerOrEqualThanFive () {
        GildedRose gildedRose = gildedRoseSelling(
                backstagePassesItem(5, 1),
                backstagePassesItem(1, 10),
                backstagePassesItem(5, 49),
                backstagePassesItem(5, 50)
        );
        gildedRose.updateQuality();
        assertEquals(4, gildedRose.items[0].quality);
        assertEquals(13, gildedRose.items[1].quality);
        assertEquals(50, gildedRose.items[2].quality);
        assertEquals(50, gildedRose.items[3].quality);
    }

    @Test
    public void backstagePassesQualityDropsToZeroWhenSellInLowerOrEqualThanZero () {
        GildedRose gildedRose = gildedRoseSelling(
                backstagePassesItem(0, 10)
        );
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].quality);
    }
}
