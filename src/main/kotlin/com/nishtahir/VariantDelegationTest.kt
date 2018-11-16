package com.nishtahir

fun test() {
    "%.1f mi".format(10f)
}

sealed class State() {
    class DESTROYED : State()
}

interface Lifecycle {
    fun setCurrentState(state: State)
    fun getCurrentState(): State
}

class TestLifecycle : Lifecycle {
    override fun setCurrentState(state: State) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentState(): State {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // Doesn't work
//    var currentState: State = State.DESTROYED()
//    override public get
//    override public set(value) {}
}