package com.gildedrose

import kotlin.math.max
import kotlin.math.min

class GildedRose(var items: List<Item>) {

    private val SULFURAS = "Sulfuras, Hand of Ragnaros"
    private val BRIE = "Aged Brie"
    private val PASS = "Backstage passes to a TAFKAL80ETC concert"

    private val MIN_QUALITY = 0
    private val MAX_QUALITY = 50

    private val PASS_QUALITY_BUMP_1 = 10
    private val PASS_QUALITY_BUMP_2 = 5

    fun addOrDetractFromItem(item : Item, change: Int){
        item.quality += change
        item.quality = min(item.quality, MAX_QUALITY)     //returns 50 if quality > 50
        item.quality = max(item.quality, MIN_QUALITY)     //returns 0 if quality < 0
    }

    fun updateQuality() {

        for (item in items) {

            if (item.name != SULFURAS) {

                var qualityDecline = -1
                var qualityIncrease = 1

                item.sellIn -= 1

                if (item.sellIn < 0) {
                    qualityDecline *= 2
                    qualityIncrease *= 2
                }

                when (item.name) {
                    BRIE -> {
                        addOrDetractFromItem(item, qualityIncrease)
                    }
                    PASS -> {
                        if (item.sellIn < 0) {
                            item.quality = 0
                        } else if (item.sellIn < PASS_QUALITY_BUMP_2) {
                            addOrDetractFromItem(item, 3)
                        } else if (item.sellIn < PASS_QUALITY_BUMP_1) {
                            addOrDetractFromItem(item, 2)
                        } else {
                            addOrDetractFromItem(item, 1)
                        }
                    }
                    else -> {
                        addOrDetractFromItem(item, qualityDecline)
                    }
                }
            }
        }
    }

}

