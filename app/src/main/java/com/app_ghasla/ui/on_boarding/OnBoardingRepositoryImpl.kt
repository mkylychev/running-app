package com.app_ghasla.ui.on_boarding

import androidx.appcompat.content.res.AppCompatResources
import com.app_ghasla.R
import com.app_ghasla.common.model.OnBoardingItem
import com.app_ghasla.data.resources.ResourcesProvider

class OnBoardingRepositoryImpl(
    private val resources: ResourcesProvider
) : OnBoardingRepository {

    /**
     * Get On Boarding images
     */
    override fun getOnBoardingImages(): List<OnBoardingItem> {
        return listOfNotNull(
            OnBoardingItem(
                AppCompatResources.getDrawable(
                    resources.getContext(),
                    R.drawable.ic_launcher_background
                ),
                resources.getString(R.string.on_boarding_first_title)
            ),
            OnBoardingItem(
                AppCompatResources.getDrawable(
                    resources.getContext(),
                    R.drawable.ic_launcher_background
                ),
                resources.getString(R.string.on_boarding_second_title)
            ),
            OnBoardingItem(
                AppCompatResources.getDrawable(
                    resources.getContext(),
                    R.drawable.ic_launcher_background
                ),
                resources.getString(R.string.on_boarding_third_title)
            )
        )
    }
}