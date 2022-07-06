package com.emreonal.cvapp.presentation.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<B : ViewDataBinding>(@LayoutRes val contentLayoutId: Int) : Fragment(),
    IBaseView {

    private var _binding: ViewDataBinding? = null

    protected val binding: B
        get() = _binding as B

    private lateinit var loadingDialog: Dialog
    private val isActive
        get() = isAdded

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        loadingDialog = LoadingDialog(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = DataBindingUtil.inflate<B>(inflater, contentLayoutId, container, false)
        (_binding as B).lifecycleOwner = this
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onDataBound()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onError(message: String?, finishScreen: Boolean) {
        if (!isAdded) return

        setLoadingIndicator(false)

    }

    override fun setLoadingIndicator(
        loading: Boolean,
        rootVisible: Boolean,
    ) {
        if (::loadingDialog.isInitialized) {
            loadingDialog.apply {
                if (loading) {
                    if (!isShowing && isActive) show()
                } else {
                    if (isShowing) dismiss()
                }

            }
        }
    }

    override fun handleState(viewModel: BaseViewModel) {
        viewModel.state.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> setLoadingIndicator(true, rootVisible = it.rootVisible)
                Status.SUCCESS -> setLoadingIndicator(false, rootVisible = true)
                Status.ERROR -> onError(it.messages?.toString(), it.finishScreen)
            }
        }
    }

    override fun onDestroyView() {
//        if (loadingDialog.isShowing) loadingDialog.dismiss()
        super.onDestroyView()
    }

    abstract fun onDataBound()
}