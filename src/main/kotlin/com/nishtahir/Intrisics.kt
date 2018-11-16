package com.nishtahir

fun boolTest(param: String?) {
    require(!param.isNullOrBlank()) { "Param must not be empty" }
}


