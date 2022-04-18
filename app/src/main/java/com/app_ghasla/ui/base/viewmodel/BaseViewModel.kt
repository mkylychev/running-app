package com.app_ghasla.ui.base.viewmodel

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app_ghasla.common.error.ErrorMessage
import com.app_ghasla.common.error.toErrorMessage
import com.app_ghasla.common.mvi.ViewAction
import com.app_ghasla.common.mvi.ViewEffect
import com.app_ghasla.common.mvi.ViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<Action : ViewAction, State : ViewState, Effect : ViewEffect> :
    ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onHandleError(throwable.toErrorMessage())
    }

    private val initialViewState by lazy { setInitialState() }

    private val _viewState = MutableStateFlow(initialViewState)
    val viewState: StateFlow<State> get() = _viewState.asStateFlow()

    private val _viewEffect = Channel<Effect>(capacity = Channel.BUFFERED)
    val viewEffect: Flow<Effect> get() = _viewEffect.receiveAsFlow()

    /**
     * State: Initial
     */
    abstract fun setInitialState(): State

    /**
     * Action
     */
    abstract fun setAction(action: Action)

    /**
     * State
     */
    protected fun getState() = viewState.value

    protected fun setState(block: State.() -> State) {
        _viewState.tryEmit(viewState.value.block())
    }

    @RestrictTo(RestrictTo.Scope.TESTS)
    fun setStateForUnitTest(block: State.() -> State) {
        _viewState.tryEmit(viewState.value.block())
    }

    /**
     * Effect
     */
    protected fun setEffect(block: () -> Effect) {
        _viewEffect.trySend(block())
    }

    /**
     * Launch
     */
    protected fun launch(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(context = exceptionHandler, block = block)

    /**
     * Error
     */
    open fun onHandleError(error: ErrorMessage) {
    }
}