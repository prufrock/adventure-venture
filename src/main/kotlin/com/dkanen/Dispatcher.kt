package com.dkanen

interface Dispatcher<T> {
    fun subscribe(subscriberFunction: (T) -> Unit)
    fun subscribe(newSubscriber: GenericSubscriber<T>)
    fun broadcast(event: T)
}

