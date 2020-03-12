package com.dkanen

import kotlin.reflect.typeOf
import kotlin.test.Test
import kotlin.test.*

class GenericDispatcherTest {

    @Test
    fun `it can be instantiated`() {
        val dispatcher = GenericDispatcher<String>()
        assertTrue(true)
    }
}
