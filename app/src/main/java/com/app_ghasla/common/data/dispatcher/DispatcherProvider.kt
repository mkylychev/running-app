package com.app_ghasla.common.data.dispatcher

import kotlinx.coroutines.Dispatchers

class DispatcherProvider {
    val default = Dispatchers.Default
    val main = Dispatchers.Main
    val io = Dispatchers.IO
}