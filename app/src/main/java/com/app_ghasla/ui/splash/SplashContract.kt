package com.app_ghasla.ui.splash

import com.app_ghasla.core.mvi.ViewAction
import com.app_ghasla.core.mvi.ViewEffect
import com.app_ghasla.core.mvi.ViewState


class SplashContract {

    sealed class Action : ViewAction {
        object CheckAuthState : Action()
        object CheckPremiumSubscription : Action()
        object NavigateToHomeScreen : Action()
    }

    data class State(
        val isPremium: Boolean? = null,
    ) : ViewState

    sealed class Effect : ViewEffect {
        object NavigateToAuthScreen : Effect()
        object NavigateToOnBoardingScreen : Effect()
        object NavigateToPersonalInfoScreen : Effect()
        object NavigateToHomeScreen : Effect()
    }
}