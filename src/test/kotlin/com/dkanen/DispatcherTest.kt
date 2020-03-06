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

        dispatcher.subscribe { event -> passedValue = event }
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

    @Test
    fun `more than one Subscriber can receive a broadcast`() {
        val dispatcher = Dispatcher()

        var firstValue = ""

        dispatcher.subscribe { event -> firstValue = event }

        var secondValue = ""

        dispatcher.subscribe { event -> secondValue = event }

        dispatcher.broadcast("event")

        assertEquals("event", firstValue)
        assertEquals("event", secondValue)
    }

    @Test
    fun `it can dispatch an empty event object`() {
        val dispatcher = Dispatcher()

        var passedValue: Event = EmptyEvent()

        dispatcher.eventSubscribe { event -> passedValue = event }

        assertEquals("", passedValue.name)
    }

    @Test
    fun `it can dispatch an emitted event object`() {
        val dispatcher = Dispatcher()

        var passedValue: Event = EmittedEvent("emittedSound")

        dispatcher.eventSubscribe { event -> passedValue = event }

        assertEquals("emittedSound", passedValue.name)
    }
}
