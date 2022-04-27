package com.app_ghasla.ui.on_boarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.app_ghasla.core.extension.observe
import com.app_ghasla.databinding.FragmentOnBoardingBinding
import com.app_ghasla.domain.OnBoardingViewModel
import com.app_ghasla.ui.base.fragment.BaseFragment
import com.app_ghasla.core.contract.OnBoardingContract.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnBoardingFragment: BaseFragment<FragmentOnBoardingBinding>() {

    private val viewModel by viewModel<OnBoardingViewModel>()
    private val onBoardingAdapter by lazy { OnBoardingAdapter() }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentOnBoardingBinding
        get() = FragmentOnBoardingBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initViewModel()
        getOnBoardingImages()
    }

    private fun initUi() {
        setOnBoardingViewPager()
        setupNextButton()
        setupSkipButton()
    }

    /**
     * On boarding: ViewPager
     */
    private fun setOnBoardingViewPager() = with(binding.vpOnBoarding) {
        adapter = onBoardingAdapter
        binding.dotsIndicator.setViewPager2(this)
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
              //  viewModel.setAction(Action.CurrentPageChanged(position))
            }
        })
    }

    /**
     * Next button
     */
    private fun setupNextButton() = with(binding.btnNext) {
        setOnClickListener {
            viewModel.setAction(Action.Next)
        }
    }

    /**
     * Skip button
     */
    private fun setupSkipButton() = with(binding.tvSkip) {
        setOnClickListener {
            viewModel.setAction(Action.Skip)
        }
    }

    /**
     * State
     */
    private fun getOnBoardingImages() {
        viewModel.setAction(Action.GetOnBoardingImages)
    }

    /**
     * ViewModel
     */
    private fun initViewModel() = with(viewModel) {
        viewState.observe(viewLifecycleOwner) { state -> onState(state) }
        viewEffect.observe(viewLifecycleOwner) { effect -> onEffect(effect) }
    }

    /**
     * State
     */
    private fun onState(state: State) = with(binding) {
        with(state) {
            onBoardingImages?.let {
                onBoardingAdapter.submitList(it)
            }
            currentPage?.let {
                vpOnBoarding.currentItem = it
            }
            isSkipped?.let {

            }
        }
    }

    /**
     * Effect
     */
    private fun onEffect(effect: Effect) {
        when (effect) {
            is Effect.ShowError -> showErrorDialog(effect.message)
        }
    }

    companion object {
        const val DEEP_LINK = "appnav://on_boarding"
    }
}