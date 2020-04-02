package com.dkanen

import kotlin.test.Test
import kotlin.test.*

class TavernTest {

    @Test
    fun `it has a name`() {
        val tavern = Tavern("Turquoise Turtle", DualModeDispatcher())
        assertEquals("Turquoise Turtle", tavern.name)
    }

    @Test
    fun `when it hears "walk" it sends "walked"`() {
        val ether = DualModeDispatcher()
        Tavern("Turquoise Turtle", ether)

        var heard = ""
        ether.subscribe { event -> if(event == "walked") heard = "walked" }
        ether.broadcast("walk")

        assertEquals("walked", heard)
    }
}
