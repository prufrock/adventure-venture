package com.dkanen

class Adventurer(val name: String) {

    var location: Int = 0

    fun walk(): Int = (++location)

    fun talk(): String = "You talk to no one in particular."

    fun listen(): String = "There is no sound to hear."

    fun talk(listener: Adventurer): String = "Talking to yourself may be a sign of genius"

    fun heard(): String = "How fair the beets at this establishment?"

}
