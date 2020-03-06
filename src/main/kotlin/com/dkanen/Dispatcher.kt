package com.dkanen

class Dispatcher {

    val simpleSubscriberList: MutableList<(String) -> Unit> = mutableListOf()
    val eventSubscriberList: MutableList<(EmptyEvent) -> Unit> = mutableListOf()

    fun subscribe(subscriberFunction: (String) -> Unit) {
        simpleSubscriberList.add(subscriberFunction)
    }

    fun eventSubscribe(subscriberFunction: (Event) -> Unit) {
        eventSubscriberList.add(subscriberFunction)
    }

    fun broadcast(event: String) {
        simpleSubscriberList.map { subscriber -> subscriber(event)}
    }

    fun subscribe(newSubscriber: Subscriber) {
        simpleSubscriberList.add({ event -> newSubscriber.receive(event)})
    }
}