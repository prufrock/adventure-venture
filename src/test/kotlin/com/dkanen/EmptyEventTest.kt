package com.dkanen

import kotlin.test.Test
import kotlin.test.*

class EmptyEventTest {
    @Test
    fun `an empty event has an empty string for a name`() {
        val event = EmptyEvent()
        assertEquals("", event.name)
    }
}
