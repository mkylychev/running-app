package com.app_ghasla.ui.on_boarding

import com.app_ghasla.common.constant.firstPage
import com.app_ghasla.common.constant.nextPage
import com.app_ghasla.data.preferences.PreferencesService
import com.app_ghasla.ui.base.viewmodel.BaseViewModel
import com.app_ghasla.ui.on_boarding.OnBoardingContract.*

class OnBoardingViewModel(
    private val repository: OnBoardingRepository,
    private val preferences: PreferencesService
) : BaseViewModel<Action, State, Effect>() {
    override fun setInitialState() = State(isFirstPage = true)

    override fun setAction(action: Action) {
        when (action) {
            is Action.GetOnBoardingImages -> getOnBoardingImages()
            is Action.CurrentPageChanged -> {}
            is Action.Next -> next()
            is Action.Skip -> skip()
        }
    }

    /**
     * Get On Boarding images
     */
    private fun getOnBoardingImages() {
        setState { copy(onBoardingImages = repository.getOnBoardingImages()) }
    }

    /**
     * On Next clicked
     */
    private fun next() {
        val nextPage = (getState().currentPage
            ?: firstPage) + if (getState().isFirstPage == true) firstPage else nextPage
        when (val isLastPage = nextPage == (getState().onBoardingImages?.size)) {
            true -> {
                preferences.isOnBoardingPassed = true
                setState {
                    copy(isLastPage = isLastPage, isFirstPage = false)
                }
            }
            false -> {
                setState {
                    copy(currentPage = nextPage, isFirstPage = false)
                }
            }
        }
    }

    /**
     * Skip On Boarding
     */
    private fun skip() {
        preferences.isOnBoardingPassed = true
        setState { copy(isSkipped = true) }
    }
}