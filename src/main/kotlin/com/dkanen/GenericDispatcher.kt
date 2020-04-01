package com.dkanen

class GenericDispatcher<T> {

    private val subscriberList: MutableList<(T) -> Unit> = mutableListOf()

    fun subscribe(subscriberFunction: (T) -> Unit) {
        subscriberList.add(subscriberFunction)
    }

    fun broadcast(event: T) {
        subscriberList.map { subscriber -> subscriber(event)}
    }
}