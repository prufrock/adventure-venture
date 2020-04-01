package com.dkanen

import kotlin.reflect.typeOf
import kotlin.test.Test
import kotlin.test.*

class GenericDispatcherTest {

    class SimpleSubscriber: GenericSubscriber<Event> {

        var message:Event = EmptyEvent()

        override fun receive(event: Event) {
            message = event
        }
    }

    @Test
    fun `it can be instantiated`() {
        val dispatcher = GenericDispatcher<Event>()
        assertTrue(true)
    }

    @Test
    fun `when a Subscriber is passed to subscribe it can receive a broadcast`() {
        val dispatcher = GenericDispatcher<Event>()

        val subscriber = SimpleSubscriber()

        dispatcher.subscribe(subscriber)

        dispatcher.broadcast(EmittedEvent("droppedCookie"))

        assertEquals("droppedCookie", subscriber.message.name)
    }

    @Test
    fun `more than one Subscriber can receive a broadcast`() {
        val dispatcher = GenericDispatcher<Event>()

        var firstValue: Event = EmptyEvent()

        dispatcher.subscribe { event -> firstValue = event }

        var secondValue: Event = EmptyEvent()

        dispatcher.subscribe { event -> secondValue = event }

        dispatcher.broadcast(EmittedEvent("droppedScone"))

        assertEquals("droppedScone", firstValue.name)
        assertEquals("droppedScone", secondValue.name)
    }


    @Test
    fun `it can dispatch an empty event object`() {
        val dispatcher = GenericDispatcher<Event>()

        var passedValue: Event = EmptyEvent()

        dispatcher.subscribe { event -> passedValue = event }

        assertEquals("", passedValue.name)
    }

    @Test
    fun `it can dispatch an emitted event object`() {
        val dispatcher = GenericDispatcher<Event>()

        var passedValue: Event = EmittedEvent("emittedSound")

        dispatcher.subscribe { event -> passedValue = event }

        assertEquals("emittedSound", passedValue.name)
    }
}
