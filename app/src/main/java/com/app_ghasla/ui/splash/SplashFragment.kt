package com.app_ghasla.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app_ghasla.R
import com.app_ghasla.core.extension.navigate
import com.app_ghasla.core.extension.observe
import com.app_ghasla.databinding.FragmentSplashBinding
import com.app_ghasla.navigation.NavCommand
import com.app_ghasla.navigation.NavCommands
import com.app_ghasla.ui.base.fragment.BaseFragment
import com.app_ghasla.ui.on_boarding.OnBoardingFragment
import com.app_ghasla.ui.splash.SplashContract.Action
import com.app_ghasla.ui.splash.SplashContract.Effect
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    private val viewModel by viewModel<SplashViewModel>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSplashBinding
        get() = FragmentSplashBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initState()
    }

    /**
     * ViewModel
     */
    private fun initViewModel() = with(viewModel) {
        viewEffect.observe(viewLifecycleOwner) { effect -> onEffect(effect) }
    }

    /**
     * State
     */
    private fun initState() {
        viewModel.setAction(Action.CheckAuthState)
    }

    /**
     * Effect
     */
    private fun onEffect(effect: Effect) {
        when (effect) {
            is Effect.NavigateToAuthScreen -> navigateToAuthScreen()
            is Effect.NavigateToOnBoardingScreen -> navigateToOnBoardingScreen()
            is Effect.NavigateToPersonalInfoScreen -> {
                //  navigateToPersonalInfoScreen()
            }
            is Effect.NavigateToHomeScreen -> {
                //navigateToHomeScreen()
            }
        }
    }

    /**
     * Navigation
     */
    private fun navigateToAuthScreen() = navigate(
        NavCommand(NavCommands.Id(id = R.id.graph_auth, isSingleTop = true))
    )

    private fun navigateToOnBoardingScreen() = navigate(
        NavCommand(NavCommands.DeepLink(link = OnBoardingFragment.DEEP_LINK, isSingleTop = true))
    )

//    private fun navigateToPersonalInfoScreen() = navigate(
//        NavCommand(NavCommands.DeepLink(link = PersonalInfoFragment.DEEP_LINK, isSingleTop = true))
//    )
//
//    private fun navigateToHomeScreen() = navigate(
//        NavCommand(NavCommands.DeepLink(link = HomeFragment.DEEP_LINK, isSingleTop = true))
//    )
}