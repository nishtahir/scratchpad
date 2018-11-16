package com.nishtahir

import java.util.*

open class AA {

}

enum class SomeEnum {
    THING
}

data class SomeClass(val string: String) {
    constructor(value: SomeEnum) : this(value.toString())
}

typealias TestAlias = String

fun TestAlias.test() {
    val thing = Collections.EMPTY_LIST
    val list = emptyList<String>()
}

fun open() {
    "".test()
}