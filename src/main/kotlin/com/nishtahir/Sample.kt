package com.nishtahir

object Sample {

    @JvmStatic
    fun main(args: Array<String>) {
        println(C().getTag())
    }

}

abstract class A {
    fun getTag(): String {
        return this::class.java.simpleName
    }
}

open class B {

}

class C : A() {

}

class D : B() {

}
