package com.app_ghasla.ui.splash

import com.app_ghasla.core.constant.SPLASH_DELAY
import com.app_ghasla.data.dispatcher.DispatcherProvider
import com.app_ghasla.ui.base.viewmodel.BaseViewModel
import com.app_ghasla.ui.splash.SplashContract.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class SplashViewModel(
    private val dispatcher: DispatcherProvider,
  //  private val repository: AuthRepository
) : BaseViewModel<Action, State, Effect>() {

    override fun setInitialState() = State()

    override fun setAction(action: Action) {
        when (action) {
            is Action.CheckAuthState -> checkAuthState()
        }
    }

    /**
     * Auth State
     */
    private fun checkAuthState() = launch {
        withContext(dispatcher.io) {
            delay(SPLASH_DELAY)
            setEffect { Effect.NavigateToAuthScreen}
//            with(repository) {
//                when {
//                    (authUser == null || authUser?.isEmailVerified == false) -> {
//                        setEffect { Effect.NavigateToAuthScreen }
//                    }
//                    else -> when (isCurrentFirestoreUserInformationCompleted()) {
//                        true -> setEffect { Effect.NavigateToHomeScreen }
//                        false -> setEffect { Effect.NavigateToPersonalInfoScreen }
//                    }
//                }
//            }
        }
    }
}