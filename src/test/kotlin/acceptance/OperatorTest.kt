package com.dkanen

import kotlin.test.Test
import kotlin.test.*

class OperatorTest {
    @Test
    fun `the addition operator can be used to add 1 to get 2`() {
        val x = 1
        val y = (x + 1)
        assertEquals(2, y)
    }

    @Test
    fun `the addition operator can be used to add 1 to get 2 with higher precendence than assignment`() {
        val x = 1
        val y = x + 1
        assertEquals(2, y)
    }

    @Test
    fun `the prefix operator returns the result`() {
        var x = 1
        val y = ++x
        assertEquals(2, x, "x")
        assertEquals(2, y, "y")
    }

    @Test
    fun `the postfix operator doesn't return the result`() {
        var x = 1
        val y = x++
        assertEquals(2, x)
        assertEquals(1, y)
    }
}
