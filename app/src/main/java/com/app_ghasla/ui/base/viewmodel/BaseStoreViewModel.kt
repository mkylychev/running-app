package com.app_ghasla.ui.base.viewmodel

import com.app_ghasla.common.mvi.ViewAction
import com.app_ghasla.common.mvi.ViewEffect
import com.app_ghasla.common.mvi.ViewState
import com.app_ghasla.common.mvi.ViewStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseStoreViewModel<Store : ViewStore, Action : ViewAction, State : ViewState, Effect : ViewEffect> :
    BaseViewModel<Action, State, Effect>() {

    private val initialViewStore by lazy { setInitialStore() }

    private val _viewStore = MutableStateFlow(initialViewStore)
    val viewStore: StateFlow<Store> get() = _viewStore.asStateFlow()

    /**
     * Store: Initial
     */
    abstract fun setInitialStore(): Store

    /**
     * Store
     */
    protected fun getStore() = viewStore.value

    protected fun setStore(block: Store.() -> Store) {
        _viewStore.tryEmit(viewStore.value.block())
    }
}