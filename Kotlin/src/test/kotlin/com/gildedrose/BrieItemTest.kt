package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BrieItemTest {

    val brieName = "Aged Brie"

    @Test
    fun brieItem_NormalDate_NormalQuality() {
        val items = listOf(Item(brieName, 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun brieItem_ZeroDate_NormalQuality() {
        val items = listOf(Item(brieName, 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun brieItem_NormalDate_HighQuality() {
        val items = listOf(Item(brieName, 10, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun brieItem_ZeroDate_HighQuality() {
        val items = listOf(Item(brieName, 0, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun brieItem_ZeroDate_AlmostHighQuality() {
        val items = listOf(Item(brieName, 0, 49))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun brieItem_NormalDate_AlmostHighQuality() {
        val items = listOf(Item(brieName, 10, 49))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(50, app.items[0].quality)
    }
}