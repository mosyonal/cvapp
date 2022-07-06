package com.emreonal.cvapp.presentation.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding>: AppCompatActivity(), IBaseView {

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    private lateinit var loadingDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        onViewBound()
//        loadingDialog = LoadingDialog(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onError(message: String?, finishScreen: Boolean) {
        if (!isFinishing) return

        setLoadingIndicator(false)

    }

    override fun setLoadingIndicator(
        loading: Boolean,
        rootVisible: Boolean,
    ) {
        if (::loadingDialog.isInitialized) {
            loadingDialog.apply {
                if (loading) {
                    if (!isShowing && !isFinishing) show()
                } else {
                    if (isShowing) dismiss()
                }
            }
        }
    }

    override fun handleState(viewModel: BaseViewModel) {
        viewModel.state.observe(this) {
            when (it.status) {
                Status.LOADING -> setLoadingIndicator(true, rootVisible = it.rootVisible)
                Status.SUCCESS -> setLoadingIndicator(false, rootVisible = true)
                Status.ERROR -> onError(it.messages?.toString(), it.finishScreen)
            }
        }
    }

    abstract fun onViewBound()

}