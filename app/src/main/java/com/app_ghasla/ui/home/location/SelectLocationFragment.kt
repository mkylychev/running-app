package com.app_ghasla.ui.home.location

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app_ghasla.databinding.FragmentSelectCarBinding
import com.app_ghasla.databinding.FragmentSelectLocationBinding
import com.app_ghasla.ui.base.fragment.BaseFragment

class SelectLocationFragment: BaseFragment<FragmentSelectLocationBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSelectLocationBinding
    get() = FragmentSelectLocationBinding::inflate

    companion object {
        const val DEEP_LINK = "appnav://select_location"
    }
}