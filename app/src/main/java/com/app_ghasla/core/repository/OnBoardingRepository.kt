package com.app_ghasla.core.repository

import com.app_ghasla.core.model.OnBoardingItem

interface OnBoardingRepository {
    fun getOnBoardingImages(): List<OnBoardingItem>
}