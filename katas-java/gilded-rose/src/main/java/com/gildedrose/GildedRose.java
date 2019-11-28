package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (isBackstage(item)) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }

            item.sellIn = item.sellIn - 1;

			if (item.sellIn < 0) {
				if (isBackstage(item)) {
					item.quality = 0;
				}
			}
        } else if (isAgedBrie(item)) {
            increaseQuality(item);
            item.sellIn = item.sellIn - 1;
			if (item.sellIn < 0) {
				increaseQuality(item);
			}
        } else if (isSulfuras(item)) {

        } else {
            decreaseQuality(item);
            item.sellIn = item.sellIn - 1;
			if (item.sellIn < 0) {
				decreaseQuality(item);
			}
        }
    }

    private void decreaseQuality(Item item) {
        if (hasQuality(item)) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private boolean hasQuality(Item item) {
        return item.quality > 0;
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }


}
