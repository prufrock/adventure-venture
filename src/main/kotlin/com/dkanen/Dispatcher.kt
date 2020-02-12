package com.dkanen

class Dispatcher {

    var subscriber: (String) -> String = { "test"  }

    fun subscribe(subscriberFunction: (String) -> String) {
        subscriber = subscriberFunction
    }

    fun broadcast(event: String) {
        subscriber(event)
    }
}
