package com.app_ghasla.ui.home.select_package

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app_ghasla.databinding.FragmentSelectCarBinding
import com.app_ghasla.ui.base.fragment.BaseFragment

class SelectPackageFragment: BaseFragment<FragmentSelectCarBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSelectCarBinding
        get() = FragmentSelectCarBinding::inflate

    companion object {
        const val DEEP_LINK = "appnav://select_package"
    }
}