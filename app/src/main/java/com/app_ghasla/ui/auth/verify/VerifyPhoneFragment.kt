package com.app_ghasla.ui.auth.verify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app_ghasla.R
import com.app_ghasla.core.extension.setLink
import com.app_ghasla.databinding.FragmentVerifyPhoneBinding
import com.app_ghasla.ui.base.fragment.BaseFragment

class VerifyPhoneFragment : BaseFragment<FragmentVerifyPhoneBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentVerifyPhoneBinding
        get() = FragmentVerifyPhoneBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        setResendTextView()
    }

    /**
     * Resend sms code
     */
    private fun setResendTextView() = with(binding.tvDoNotReceiveCode) {
        setLink(
            getString(R.string.verify_screen_code_do_not_receive_code),
            getString(R.string.verify_screen_code_do_not_receive_code_resend),
            requireContext()
        ) { resendCode() }
    }

    private fun resendCode() {

    }
}