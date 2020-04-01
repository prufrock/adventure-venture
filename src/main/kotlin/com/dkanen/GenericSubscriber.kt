package com.dkanen

interface GenericSubscriber<T> {

    fun receive(event: T)
}