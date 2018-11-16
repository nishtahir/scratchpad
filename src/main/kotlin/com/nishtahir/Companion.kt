package com.nishtahir

const val test = 33

fun main(args: Array<String>) {
    CompanionTest()
}
class CompanionTest {

    init {
        invoke()
    }

    companion object {
        operator fun invoke() {
            println("companion invoke called")
        }
    }

}