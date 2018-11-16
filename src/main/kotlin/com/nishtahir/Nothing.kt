package com.nishtahir


fun main(args: Array<String>) {

    val nothing: Void = Class.forName("java.lang.Void").getConstructor().newInstance() as Void

    val test_ = when (nothing) {
        is Nothing -> println("I am Nothing")
        else -> println("I have a value")
    }
}
