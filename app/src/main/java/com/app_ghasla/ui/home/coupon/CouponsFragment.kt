package com.app_ghasla.ui.home.coupon

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app_ghasla.databinding.FragmentCouponsBinding
import com.app_ghasla.ui.base.fragment.BaseFragment

class CouponsFragment: BaseFragment<FragmentCouponsBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCouponsBinding
        get() = FragmentCouponsBinding::inflate
}