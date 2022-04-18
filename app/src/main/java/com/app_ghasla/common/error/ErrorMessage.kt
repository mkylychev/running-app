package com.app_ghasla.common.error

sealed class ErrorMessage(val message: String) {
    class NoInternetError(message: String) : ErrorMessage(message)
    class FirebaseError(message: String) : ErrorMessage(message)
    class UnknownError(message: String) : ErrorMessage(message)
}