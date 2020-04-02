package com.dkanen

interface Subscriber: GenericSubscriber<String> {

    override fun receive(event: String)
}