package com.emreonal.cvapp.presentation.base

class State(
    val status: Status,
    val messages: List<String>? = null,
    val rootVisible: Boolean = false,
    val finishScreen: Boolean = false,
) {
    companion object {
        fun success() = State(status = Status.SUCCESS)
        fun error(
            messages: List<String>? = null,
            finishScreen: Boolean,
        ) = State(status = Status.ERROR, messages, finishScreen = finishScreen)

        fun loading(rootVisible: Boolean = false) =
            State(status = Status.LOADING, rootVisible = rootVisible)
    }
}

enum class Status {
    LOADING, SUCCESS, ERROR
}