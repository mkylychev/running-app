package com.app_ghasla.ui.base.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

abstract class BaseDialogFragment<VB : ViewBinding> : DialogFragment() {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    abstract val TAG: String
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
    abstract fun setDialogWindow()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setDialogWindow()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun show(fragmentManager: FragmentManager) {
        if (fragmentManager.findFragmentByTag(TAG) == null) show(fragmentManager, TAG)
    }
}