package com.app_ghasla.ui.home.location

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app_ghasla.databinding.FragmentSelectCarBinding
import com.app_ghasla.ui.base.fragment.BaseFragment

class SelectLocationFragment: BaseFragment<FragmentSelectCarBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSelectCarBinding
    get() = FragmentSelectCarBinding::inflate

    companion object {
        const val DEEP_LINK = "appnav://select_car"
    }
}