package com.example.mobile_app_final_assignment.models

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class DashboardItemTest {

    @Test
    fun `object is created with correct values`() {
        val item = DashboardItem(
            name = "Empire State Building",
            architect = "Shreve, Lamb & Harmon",
            location = "New York",
            yearCompleted = "1931",
            style = "Art Deco",
            height = 381,
            description = "Famous skyscraper"
        )

        assertEquals("Empire State Building", item.name)
        assertEquals("Shreve, Lamb & Harmon", item.architect)
        assertEquals("New York", item.location)
        assertEquals("1931", item.yearCompleted)
        assertEquals("Art Deco", item.style)
        assertEquals(381, item.height)
        assertEquals("Famous skyscraper", item.description)
    }

    @Test
    fun `handles null values correctly`() {
        val item = DashboardItem(
            name = null,
            architect = null,
            location = null,
            yearCompleted = null,
            style = null,
            height = null,
            description = null
        )

        assertNull(item.name)
        assertNull(item.architect)
        assertNull(item.location)
        assertNull(item.yearCompleted)
        assertNull(item.style)
        assertNull(item.height)
        assertNull(item.description)
    }
}
