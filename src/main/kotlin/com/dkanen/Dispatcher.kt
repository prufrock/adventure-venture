package com.dkanen

class Dispatcher {

    var size = 0

    fun dispatch(s: String) {
        size++
    }

    fun has(s: String): Boolean {
        return size > 0
    }

}
