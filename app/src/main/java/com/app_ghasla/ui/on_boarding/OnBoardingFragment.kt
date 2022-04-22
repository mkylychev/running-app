package com.app_ghasla.ui.on_boarding

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app_ghasla.databinding.FragmentOnBoardingBinding
import com.app_ghasla.ui.base.fragment.BaseFragment

class OnBoardingFragment: BaseFragment<FragmentOnBoardingBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentOnBoardingBinding
        get() = FragmentOnBoardingBinding::inflate


}