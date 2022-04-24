package com.app_ghasla.ui.on_boarding

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app_ghasla.databinding.FragmentOnBoardingBinding
import com.app_ghasla.ui.base.fragment.BaseFragment
import com.app_ghasla.ui.base.fragment.OnBoardingAdapter

class OnBoardingFragment: BaseFragment<FragmentOnBoardingBinding>() {

    private val onBoardingAdapter by lazy { OnBoardingAdapter() }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentOnBoardingBinding
        get() = FragmentOnBoardingBinding::inflate



    companion object {
        const val DEEP_LINK = "appnav://on_boarding"
    }
}