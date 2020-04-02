package com.dkanen

class Adventurer(val name: String, var ether: DualModeDispatcher): Subscriber {

    var location: Int = 0

    var status = "waiting"

    init {
        ether.subscribe(this)
    }

    fun walk(): Int {
        ether.broadcast("walk")
        return location
    }

    fun talk(): String = "You talk to no one in particular."

    fun listen(): String = "There is no sound to hear."

    fun talk(listener: Adventurer): String {
        ether.broadcast("talk")
        return "Talking to yourself may be a sign of genius"
    }

    fun heard(): String {
        if (status == "heard something") {
            return "How fair the beets at this establishment?"
        } else {
            return ""
        }
    }

    override fun receive(event: String) {
        if (event == "walk") {
            ++location
        } else if (event == "talk") {
            status = "heard something"
        }
    }
}
