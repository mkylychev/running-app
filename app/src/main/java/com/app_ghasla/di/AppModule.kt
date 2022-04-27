package com.app_ghasla.di

import com.app_ghasla.core.repository.OnBoardingRepository
import com.app_ghasla.data.dispatcher.DispatcherProvider
import com.app_ghasla.data.preferences.PreferencesService
import com.app_ghasla.data.resources.ResourcesProvider
import com.app_ghasla.data.notification.NotificationService
import com.app_ghasla.data.repository.OnBoardingRepositoryImpl
import com.app_ghasla.domain.OnBoardingViewModel
import com.app_ghasla.ui.splash.SplashViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    fun getModules() = listOf(
        dispatcherModule,
        resourcesModule,
        preferencesModule,
        notificationModule,
        repositoryModule,
        viewModelModule,
    )

    private val dispatcherModule = module {
        single { DispatcherProvider() }
    }

    private val resourcesModule = module {
        single { ResourcesProvider(androidApplication()) }
    }

    private val preferencesModule = module {
        single { PreferencesService(androidApplication()) }
    }

    private val notificationModule = module {
        single { NotificationService(androidApplication()) }
    }

    private val repositoryModule = module {
        single<OnBoardingRepository> { OnBoardingRepositoryImpl(get()) }
    }

    private val viewModelModule = module {
        viewModel { SplashViewModel(get()) }
        viewModel { OnBoardingViewModel(get(), get()) }
    }
}