package com.dkanen

import kotlin.test.Test
import kotlin.test.*

class AdventurerTest {
    @Test
    fun `it has a name`() {
        val susan = Adventurer("Susan the Valiant")
        assertEquals("Susan the Valiant", susan.name)
    }

    @Test
    fun `it has a position in 1 dimension`() {
        val susan = Adventurer("Susan the Valiant")
        assertEquals(0, susan.location)
    }

    @Test
    fun `it can walk in one space`() {
        val susan = Adventurer("Susan the Valiant")
        assertEquals(1, susan.walk())
    }

    @Test
    fun `it can walk two spaces`() {
        val susan = Adventurer("Susan the Valiant")
        assertEquals(1, susan.walk())
        assertEquals(2, susan.walk())
    }
}
