package com.app_ghasla.core.contract

import com.app_ghasla.core.model.OnBoardingItem
import com.app_ghasla.core.mvi.ViewAction
import com.app_ghasla.core.mvi.ViewEffect
import com.app_ghasla.core.mvi.ViewState

class OnBoardingContract {
    sealed class Action : ViewAction {
        object GetOnBoardingImages : Action()
        object Next : Action()
        object Skip : Action()
        data class CurrentPageChanged(val position: Int) : Action()
    }

    data class State(
        val onBoardingImages: List<OnBoardingItem>? = null,
        val currentPage: Int? = null,
        val isFirstPage: Boolean? = null,
        val isLastPage: Boolean? = null,
        val isSkipped: Boolean? = null
    ) : ViewState

    sealed class Effect : ViewEffect {
        data class ShowError(val message: String) : Effect()
    }
}