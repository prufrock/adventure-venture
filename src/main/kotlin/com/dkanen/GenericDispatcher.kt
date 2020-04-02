package com.dkanen

class GenericDispatcher<T> : Dispatcher<T> {

    private val subscriberList: MutableList<(T) -> Unit> = mutableListOf()

    override fun subscribe(subscriberFunction: (T) -> Unit) {
        subscriberList.add(subscriberFunction)
    }

    override fun subscribe(newSubscriber: GenericSubscriber<T>) {
        subscriberList.add { event -> newSubscriber.receive(event)}
    }

    override fun broadcast(event: T) {
        subscriberList.map { subscriber -> subscriber(event)}
    }
}