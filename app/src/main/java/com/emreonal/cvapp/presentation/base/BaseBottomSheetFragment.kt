package com.emreonal.cvapp.presentation.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.transition.Slide
import androidx.transition.TransitionManager
import com.emreonal.cvapp.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetFragment<B : ViewDataBinding> constructor(
    @LayoutRes val contentLayoutId: Int,
    private val fullPage: Boolean,
    private val draggable: Boolean,
) : BottomSheetDialogFragment(), IBaseView {

    private var _binding: ViewDataBinding? = null
    private lateinit var sheetDialog: BottomSheetDialog
    var listener: ISheetDialog? = null

    @Suppress("UNCHECKED_CAST")
    protected val binding: B
        get() = _binding as B

    private lateinit var loadingDialog: Dialog
    val isActive
        get() = isAdded

    override fun onAttach(context: Context) {
//        loadingDialog = LoadingDialog(context)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Widget_BottomSheet)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate<B>(inflater, contentLayoutId, container, false)
        container?.let { TransitionManager.beginDelayedTransition(it, Slide(Gravity.BOTTOM)) }
        return _binding?.root
    }

    @Suppress("DEPRECATION")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.let {
            it.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            it.attributes.flags =
                it.attributes.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS.inv()
            it.statusBarColor = Color.TRANSPARENT
        }
        listener?.onSheetShown()
        onDataBound()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        sheetDialog = BottomSheetDialog(requireContext(), theme)
        sheetDialog.window?.setDimAmount(0f)
        sheetDialog.behavior.isHideable = true
        sheetDialog.behavior.isDraggable = draggable
        sheetDialog.behavior.skipCollapsed = true
        sheetDialog.setOnShowListener {
            val parentLayout =
                sheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { parent ->
                setupHeight(parent)
                BottomSheetBehavior.from(parent).state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return sheetDialog
    }

    private fun setupHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = if (fullPage) WindowManager.LayoutParams.MATCH_PARENT else WindowManager.LayoutParams.WRAP_CONTENT
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun dismiss() {
        if (::sheetDialog.isInitialized) {
            sheetDialog.behavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
        listener?.onSheetDismissed()
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

    abstract fun onDataBound()

}