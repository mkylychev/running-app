package com.app_ghasla.ui.auth.create_profile

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import com.app_ghasla.R
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
        setFirstNameView()
        setLastNameView()
    }

    /**
     * First name
     */
    private fun setFirstNameView() = with(binding.vFirstName) {
        etInputField.apply {
            hint = getString(R.string.create_profile_screen_first_name)
            inputType = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
            onFocusChangeListener = inputFieldFocusChangeListener
            doAfterTextChanged {
               // viewModel.setAction(Action.FullNameChanged(it.toString()))
            }
        }
    }

    /**
     * Last name
     */
    private fun setLastNameView() = with(binding.vLastName) {
        etInputField.apply {
            hint = getString(R.string.create_profile_screen_last_name)
            inputType = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
            onFocusChangeListener = inputFieldFocusChangeListener
            doAfterTextChanged {
                // viewModel.setAction(Action.FullNameChanged(it.toString()))
            }
        }
    }
}