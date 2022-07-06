package com.emreonal.cvapp.presentation.base

interface IBaseView {
    fun onError(message: String?, finishScreen: Boolean) {}
    fun handleState(viewModel: BaseViewModel)
    fun setLoadingIndicator(loading: Boolean, rootVisible: Boolean = true)
}