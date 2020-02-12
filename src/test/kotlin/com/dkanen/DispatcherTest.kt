package com.dkanen

import kotlin.test.Test
import kotlin.test.*

class DispatcherTest {

    @Test
    fun `when a lambda is passed to subscribe it can receive a broadcast`() {
        val dispatcher = Dispatcher()

        var passedValue = ""
        val subscribeFunction: (String) -> String = { event ->
            passedValue = event
            passedValue
        }

        dispatcher.subscribe(subscribeFunction)
        dispatcher.broadcast("event")

        assertEquals("event", passedValue)
    }
}
