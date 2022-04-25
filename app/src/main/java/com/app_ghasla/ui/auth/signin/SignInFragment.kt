package com.app_ghasla.ui.auth.signin

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app_ghasla.databinding.FragmentSignInBinding
import com.app_ghasla.ui.base.fragment.BaseFragment

class SignInFragment: BaseFragment<FragmentSignInBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSignInBinding
        get() = FragmentSignInBinding::inflate


}