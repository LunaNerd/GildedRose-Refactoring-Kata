package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PassItemTest {

    val passName = "Backstage passes to a TAFKAL80ETC concert"

    // sellIn <= 10, quality += 2
    // sellIn <= 5,  quality += 3
    // sellIn == 0, quality = 0
    // else,        quality += 1

    @Test
    fun passItem_biggerThen10Date_normalQuality() {
        val items = listOf(Item(passName, 15, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(14, app.items[0].sellIn)
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun passItem_10Date_normalQuality() {
        val items = listOf(Item(passName, 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun passItem_9Date_normalQuality() {
        val items = listOf(Item(passName, 9, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].sellIn)
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun passItem_6Date_normalQuality() {
        val items = listOf(Item(passName, 6, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(5, app.items[0].sellIn)
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun passItem_5Date_normalQuality() {
        val items = listOf(Item(passName, 5, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, app.items[0].sellIn)
        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun passItem_1Date_normalQuality() {
        val items = listOf(Item(passName, 1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)
        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun passItem_0Date_normalQuality() {
        val items = listOf(Item(passName, 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun passItem_2Date_highQuality() {
        val items = listOf(Item(passName, 2, 50), Item(passName, 2, 49), Item(passName, 2, 48))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
        assertEquals(50, app.items[1].quality)
        assertEquals(50, app.items[2].quality)
    }

    @Test
    fun passItem_7Date_highQuality() {
        val items = listOf(Item(passName, 7, 50), Item(passName, 2, 49))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
        assertEquals(50, app.items[1].quality)
    }

    @Test
    fun passItem_15Date_highQuality() {
        val items = listOf(Item(passName, 15, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun passItem_0Date_highQuality() {
        val items = listOf(Item(passName, 0, 50), Item(passName, 0, 49), Item(passName, 0, 48))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
        assertEquals(0, app.items[1].quality)
        assertEquals(0, app.items[2].quality)

    }




}