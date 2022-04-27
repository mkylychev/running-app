package com.app_ghasla.ui.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    protected fun showErrorDialog(message: String) {
        if (message.isNotEmpty()) {
//            SimpleDialogFragment(
//                title = getString(R.string.dialog_titleWhoops),
//                description = message,
//                buttonPositiveTitle = getString(R.string.dialog_buttonOk)
//            ).show(childFragmentManager)
        }
    }
}