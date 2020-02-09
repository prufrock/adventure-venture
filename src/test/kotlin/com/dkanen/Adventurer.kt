package com.dkanen

class Adventurer(val name: String) {
    fun walk(): Int {
        return (++location)
    }

    var location: Int = 0
}
