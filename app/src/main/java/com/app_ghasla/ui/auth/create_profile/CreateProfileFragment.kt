package com.app_ghasla.ui.auth.create_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app_ghasla.databinding.FragmentCreateProfileBinding
import com.app_ghasla.ui.base.fragment.BaseFragment

class CreateProfileFragment: BaseFragment<FragmentCreateProfileBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCreateProfileBinding
        get() = FragmentCreateProfileBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {

    }
}