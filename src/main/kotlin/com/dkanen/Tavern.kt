package com.dkanen

class Tavern(var name: String, val ether: DualModeDispatcher): Subscriber {

    init {
        ether.subscribe(this)
    }

    override fun receive(event: String) {
        if (event == "walk") {
            ether.broadcast("walked")
        }
    }
}