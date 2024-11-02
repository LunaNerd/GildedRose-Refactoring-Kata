package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NormalItemTest {

    @Test
    fun foo() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun normalItem_NormalDate_normalQuality() {
        val items = listOf(Item("foo", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun normalItem_DateZero_normalQuality() {
        val items = listOf(Item("foo", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun normalItem_NormalDate_ZeroQuality() {
        val items = listOf(Item("foo", 10, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun normalItem_ZeroDate_ZeroQuality() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun normalItem_ZeroDate_AlmostZeroQuality() {
        val items = listOf(Item("foo", 0, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun NormalItem_AlmostZeroDate_ZeroQuality() {
        val items = listOf(Item("foo", 1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)
        assertEquals(9, app.items[0].quality)
    }
}