package com.dkanen

import kotlin.test.Test
import kotlin.test.*

class DispatcherTest {

    class SimpleSubscriber: Subscriber {

        var message = ""

        override fun receive(event: String) {
           message = event
        }
    }

    @Test
    fun `when a lambda is passed to subscribe it can receive a broadcast`() {
        val dispatcher = Dispatcher()

        var passedValue = ""
        val subscribeFunction: (String) -> Unit = { event ->
            passedValue = event
        }

        dispatcher.subscribe(subscribeFunction)
        dispatcher.broadcast("event")

        assertEquals("event", passedValue)
    }

    @Test
    fun `when a Subscriber is passed to subscribe it can receive a broadcast`() {
        val dispatcher = Dispatcher()

        val subscriber = SimpleSubscriber()

        dispatcher.subscribe(subscriber)

        dispatcher.broadcast("event")

        assertEquals("event", subscriber.message)
    }
}
