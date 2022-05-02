package com.app_ghasla.ui.home.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app_ghasla.databinding.FragmentHomeBinding
import com.app_ghasla.ui.base.fragment.BaseFragment

class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate
}