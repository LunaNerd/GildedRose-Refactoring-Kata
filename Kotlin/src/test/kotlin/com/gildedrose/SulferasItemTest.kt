package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SulferasItemTest {

    val sulferasName = "Sulfuras, Hand of Ragnaros"

    //sellIn doesn't change for sulfuras

    @Test
    fun sulferasItem_NormalDate() {
        val items = listOf(Item(sulferasName, 10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(10, app.items[0].sellIn)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun sulferasItem_ZeroDate() {
        val items = listOf(Item(sulferasName, 0, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun sulferasItem_NegativeDate() {
        val items = listOf(Item(sulferasName, -2, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-2, app.items[0].sellIn)
        assertEquals(80, app.items[0].quality)
    }



}