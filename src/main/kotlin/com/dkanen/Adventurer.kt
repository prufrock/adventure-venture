package com.dkanen

class Adventurer(val name: String) {
    fun walk(): Int {
        return (++location)
    }

    fun talk(): String {
        return "You talk to no one in particular."
    }

    fun listen(): String {
        return "There is no sound to hear."
    }

    fun talk(listener: Adventurer): String {
       return "Talking to yourself may be a sign of genius"
    }

    fun heard(): String {
       return "How fair the beets at this establishment?"
    }

    var location: Int = 0
}
