package com.app_ghasla.ui.base.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.core.view.isVisible
import com.app_ghasla.databinding.DialogFragmentSimpleBinding
import com.app_microrec.R
import com.app_microrec.common.constant.emptyString
import com.app_microrec.common.extension.getColor
import com.app_microrec.databinding.DialogFragmentSimpleBinding

class SimpleDialogFragment(
    private var title: String? = null,
    private var description: String? = null,
    private var buttonPositiveTitle: String? = null,
    @ColorRes private var buttonPositiveTitleColor: Int? = null,
    private var buttonNegativeTitle: String? = null,
    @ColorRes private var buttonNegativeTitleColor: Int? = null,
    private var buttonClick: (isPositive: Boolean) -> Unit = {},
) : BaseDialogFragment<DialogFragmentSimpleBinding>() {

    override val TAG: String = SimpleDialogFragment::class.java.simpleName

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogFragmentSimpleBinding
        get() = DialogFragmentSimpleBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(title)
        setDescription(description)
        setPositiveButton(buttonPositiveTitle, buttonPositiveTitleColor)
        setNegativeButton(buttonNegativeTitle, buttonNegativeTitleColor)
    }

    /**
     * Dialog window
     */
    override fun setDialogWindow() {
        dialog?.window?.apply {
            setBackgroundDrawableResource(R.drawable.dialog_background)
            setLayout(
                (resources.displayMetrics.widthPixels * 0.85).toInt(),
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            isCancelable = false
        }
    }

    /**
     * Title
     */
    private fun setTitle(title: String?) = with(binding.tvTitle) {
        text = title ?: emptyString
        isVisible = !title.isNullOrEmpty()
    }

    /**
     * Description
     */
    private fun setDescription(description: String?) = with(binding.tvDescription) {
        text = description ?: emptyString
        isVisible = !description.isNullOrEmpty()
    }

    /**
     * Positive button
     */
    private fun setPositiveButton(
        title: String?,
        @ColorRes titleColor: Int?
    ) = with(binding.btnPositive) {
        text = title ?: emptyString
        titleColor?.let { setTextColor(getColor(titleColor)) }
        setOnClickListener {
            buttonClick(true)
            dismiss()
        }
        isVisible = !title.isNullOrEmpty()
    }

    /**
     * Negative button
     */
    private fun setNegativeButton(
        title: String?,
        @ColorRes titleColor: Int?
    ) = with(binding.btnNegative) {
        text = title ?: emptyString
        titleColor?.let { setTextColor(getColor(titleColor)) }
        setOnClickListener {
            buttonClick(false)
            dismiss()
        }
        isVisible = !title.isNullOrEmpty()
    }
}