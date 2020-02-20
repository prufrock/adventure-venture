package com.dkanen

class Dispatcher {

    val subscriberList: MutableList<(String) -> Unit> = mutableListOf()

    fun subscribe(subscriberFunction: (String) -> Unit) {
        subscriberList.add(subscriberFunction)
    }

    fun broadcast(event: String) {
        subscriberList.map { subscriber -> subscriber(event)}
    }

    fun subscribe(newSubscriber: Subscriber) {
        subscriberList.add({event -> newSubscriber.receive(event)})
    }
}