package com.app_ghasla.ui.auth.verify

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app_ghasla.databinding.FragmentVerifyPhoneBinding
import com.app_ghasla.ui.base.fragment.BaseFragment

class VerifyPhoneFragment: BaseFragment<FragmentVerifyPhoneBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentVerifyPhoneBinding
        get() = FragmentVerifyPhoneBinding::inflate
}