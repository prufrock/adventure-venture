package com.dkanen

import kotlin.test.Test
import kotlin.test.*

class DispatcherTest {

    @Test
    fun `when it's first created it's size is 0`() {
        val dispatcher = Dispatcher()
        assertEquals(0, dispatcher.size)
    }

    @Test
    fun `when it receives an event it's size increases to 1`() {
        val dispatcher = Dispatcher()

        dispatcher.dispatch("event")

        assertEquals(1, dispatcher.size)
    }

    @Test
    fun `when it doesn't have any events it says it doesn't have the event`() {
        val dispatcher = Dispatcher()

        assertEquals(false, dispatcher.has("event"))
    }

    @Test
    fun `when it has one event and the event you give it matches it returns true`() {
        val dispatcher = Dispatcher()

        dispatcher.dispatch("event")

        assertEquals(true, dispatcher.has("event"))
    }
}
