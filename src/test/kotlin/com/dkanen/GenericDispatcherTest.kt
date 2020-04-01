package com.dkanen

import kotlin.reflect.typeOf
import kotlin.test.Test
import kotlin.test.*

class GenericDispatcherTest {

    @Test
    fun `it can be instantiated`() {
        val dispatcher = GenericDispatcher<Event>()
        assertTrue(true)
    }

    @Test
    fun `more than one Subscriber can receive a broadcast`() {
        val dispatcher = GenericDispatcher<Event>()

        var firstValue: Event = EmittedEvent("")

        dispatcher.subscribe { event -> firstValue = event }

        var secondValue: Event = EmittedEvent("")

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
