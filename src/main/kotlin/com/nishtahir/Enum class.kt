package com.nishtahir

enum class AppointmentStatus {
    SCHEDULED,
    UNSCHEDULED,
    COMPLETED;

    companion object {
        fun fromString(string: String): AppointmentStatus = try {
            AppointmentStatus.valueOf(string.toUpperCase())
        } catch (exception: IllegalArgumentException) {
            AppointmentStatus.values()[0]
        }
    }
}


enum class ETest {
    HELLO
}

inline fun <reified T : Enum<T>> Enum<T>.fromString(string: String): T {
    //...
    return this as T
    //...
}

fun function() {
    ETest.HELLO.fromString("")
    AppointmentStatus.fromString("")
}
