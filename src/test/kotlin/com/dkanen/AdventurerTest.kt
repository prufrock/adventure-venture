package com.dkanen

import kotlin.test.Test
import kotlin.test.*

class AdventurerTest {

    lateinit var susan: Adventurer

    @BeforeTest
    fun setUp() {
        susan = Adventurer("Susan the Valiant", Dispatcher())
    }

    @Test
    fun `it has a name`() {
        assertEquals("Susan the Valiant", susan.name)
    }

    @Test
    fun `it has a position in 1 dimension`() {
        assertEquals(0, susan.location)
    }

    @Test
    fun `it can walk in one space`() {
        assertEquals(1, susan.walk())
    }

    @Test
    fun `it can walk two spaces`() {
        assertEquals(1, susan.walk())
        assertEquals(2, susan.walk())
    }

    @Test
    fun `it can talk to no one in particular and get a response that's there nobody to talk to`() {
        assertEquals("You talk to no one in particular.", susan.talk())
    }

    @Test
    fun `it can listen to no one in particular`() {
        assertEquals("There is no sound to hear.", susan.listen())
    }

    @Test
    fun `it can listen to itself`() {
        assertEquals("Talking to yourself may be a sign of genius", susan.talk(susan))
    }

    @Test
    fun `it can talk to somebody else`() {
        val betty = Adventurer("Betty the Bold", Dispatcher())
        susan.talk(betty)
        assertEquals("How fair the beets at this establishment?", betty.heard() )
    }
}
