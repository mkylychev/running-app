package com.app_ghasla.ui.base.service

import com.app_ghasla.core.error.ErrorMessage
import com.app_ghasla.core.error.toErrorMessage
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlin.coroutines.CoroutineContext

open class BaseService<Effect : Any> : CoroutineScope {

    /**
     * Job
     */
    private val job = SupervisorJob()

    /**
     * Service Contract
     */
    private val _serviceEffect = Channel<Effect>(capacity = Channel.BUFFERED)
    val serviceEffect: Flow<Effect> get() = _serviceEffect.receiveAsFlow()

    /**
     * Exception Handler
     */
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onHandleError(throwable.toErrorMessage())
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    /**
     * Effect
     */
    protected fun setEffect(block: () -> Effect) {
        _serviceEffect.trySend(block())
    }

    /**
     * Launch
     */
    protected fun launch(block: suspend CoroutineScope.() -> Unit) =
        launch(context = exceptionHandler, block = block)

    /**
     * Error
     */
    open fun onHandleError(error: ErrorMessage) {
    }
}