package com.nishtahir
//
//fun foo(param: (String) -> Int) {
//    val int: Int = param("hello")
//}
//
//
//fun test(value: IntRange) {
//}

fun main(args: Array<String>) {
    val thing = object : Test {
        override var thing: String
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
            set(value) {}
    }
}

//object Itest : Test {
//    fun hell0() {
//        "".ext()
//    }
//}

//interface Test {
//    fun String.ext() {
//        println("ext")
//    }
//}

interface Test {
    var thing: String
}

