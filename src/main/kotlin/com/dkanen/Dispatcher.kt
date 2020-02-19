package com.dkanen

class Dispatcher {

    var subscriber: (String) -> Unit = {}

    fun subscribe(subscriberFunction: (String) -> Unit) {
        subscriber = subscriberFunction
    }

    fun broadcast(event: String) {
        subscriber(event)
    }

    fun subscribe(newSubscriber: Subscriber) {
        subscriber = {event -> newSubscriber.receive(event)}
    }
}
