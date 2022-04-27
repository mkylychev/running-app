package com.app_ghasla.ui.on_boarding

import com.app_ghasla.common.model.OnBoardingItem

interface OnBoardingRepository {
    fun getOnBoardingImages(): List<OnBoardingItem>
}