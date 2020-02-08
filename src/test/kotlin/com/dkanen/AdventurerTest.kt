package com.dkanen

import kotlin.test.Test
import kotlin.test.*

class AdventurerTestTest {
    @Test
    fun `an adventurer has a name`() {
        val susan = Adventurer("Susan the Valiant")
        assertEquals("Susan the Valiant", susan.name)
    }
}
