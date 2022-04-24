package com.app_ghasla.ui.on_boarding

import androidx.appcompat.content.res.AppCompatResources
import com.app_ghasla.R
import com.app_ghasla.common.model.OnBoardingItem
import com.app_ghasla.data.resources.ResourcesProvider

class OnBoardingRepository(
    private val resources: ResourcesProvider
) {

    /**
     * Get On Boarding images
     */
    fun getOnBoardingImages(): List<OnBoardingItem> {
        return listOfNotNull(
            OnBoardingItem(
            AppCompatResources.getDrawable(resources.getContext(), R.drawable.ic_launcher_background),
            "test"),
            OnBoardingItem(
            AppCompatResources.getDrawable(resources.getContext(), R.drawable.ic_launcher_background),
            "test2"))
    }
}