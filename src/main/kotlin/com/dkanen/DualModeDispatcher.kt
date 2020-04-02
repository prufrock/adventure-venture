package com.dkanen

class DualModeDispatcher: Dispatcher<String> {

    val simpleSubscriberList: MutableList<(String) -> Unit> = mutableListOf()
    val eventSubscriberList: MutableList<(Event) -> Unit> = mutableListOf()

    override fun subscribe(subscriberFunction: (String) -> Unit) {
        simpleSubscriberList.add(subscriberFunction)
    }

    fun eventSubscribe(subscriberFunction: (Event) -> Unit) {
        eventSubscriberList.add(subscriberFunction)
    }

    override fun broadcast(event: String) {
        simpleSubscriberList.map { subscriber -> subscriber(event)}
    }

    override fun subscribe(newSubscriber: GenericSubscriber<String>) {
        simpleSubscriberList.add { event -> newSubscriber.receive(event)}
    }
}