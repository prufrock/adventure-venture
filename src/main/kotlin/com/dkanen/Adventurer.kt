package com.dkanen

class Adventurer(val name: String, var ether: Dispatcher): Subscriber {

    var location: Int = 0

    init {
        ether.subscribe(this)
    }

    fun walk(): Int {
        ether.broadcast("walk")
        return location
    }

    fun talk(): String = "You talk to no one in particular."

    fun listen(): String = "There is no sound to hear."

    fun talk(listener: Adventurer): String = "Talking to yourself may be a sign of genius"

    fun heard(): String = "How fair the beets at this establishment?"

    override fun receive(event: String) {
        if (event == "walk") {
            ++location
        }
    }

}
