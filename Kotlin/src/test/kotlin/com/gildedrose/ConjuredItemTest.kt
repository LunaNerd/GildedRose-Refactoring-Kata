package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConjuredItemTest {

    @Test
    fun conjuredItem_NormalDate_NormalQuality() {
        val items = listOf(Item("conjured", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun conjuredItem_ZeroDate_NormalQuality() {
        val items = listOf(Item("conjured", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(6, app.items[0].quality)
    }

    @Test
    fun conjuredItem_ZeroDate_LowQuality() {
        val items = listOf(Item("conjured", 0, 0), Item("conjured", 0, 1), Item("conjured", 0, 2), Item("conjured", 0, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
        assertEquals(0, app.items[1].quality)
        assertEquals(0, app.items[2].quality)
        assertEquals(0, app.items[3].quality)
    }

    @Test
    fun cONJUREDItem_NormalDate_NormalQuality() {
        val items = listOf(Item("CONJURED foo", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(8, app.items[0].quality)
    }
}