package com.emreonal.cvapp.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emreonal.core.data.remote.dto.base.Resource

open class BaseViewModel: ViewModel() {

    val state: MutableLiveData<State> = MutableLiveData()

    fun <T> handleResource(resource: Resource<T>, successResultCallback: (T?) -> Unit) {
        when(resource) {
            is Resource.Error -> state.postValue(State.error(resource.messages, resource.finishScreen))
            is Resource.Loading -> state.postValue(State.loading(rootVisible = resource.rootVisible))
            is Resource.Success -> {
                state.postValue(State.success())
                successResultCallback.invoke(resource.data)
            }
        }
    }

}