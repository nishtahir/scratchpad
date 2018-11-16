package com.nishtahir

import java.util.concurrent.ThreadLocalRandom

fun main(args: Array<String>) {
    val bool: Boolean = ThreadLocalRandom.current().nextBoolean()

    val result = when (bool) {
        true -> true
        false -> false
    }

    if(bool) {

    } else {

    }

    val thing: String? = null

    if(thing != null && thing.toBoolean())
}
