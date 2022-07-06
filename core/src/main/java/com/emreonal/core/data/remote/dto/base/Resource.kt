package com.emreonal.core.data.remote.dto.base

sealed class Resource<T>(
    val data: T? = null,
    val messages: List<String>? = null,
    val rootVisible: Boolean = false,
    val finishScreen: Boolean = false,
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(
        messages: List<String>? = null,
        finishScreen: Boolean = false,
    ) : Resource<T>(messages = messages, finishScreen = finishScreen)

    class Loading<T>(rootVisible: Boolean = false) :
        Resource<T>(rootVisible = rootVisible)
}

