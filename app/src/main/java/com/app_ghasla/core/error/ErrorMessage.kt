package com.app_ghasla.core.error

sealed class ErrorMessage(val message: String) {
    class NoInternetError(message: String) : ErrorMessage(message)
    class FirebaseError(message: String) : ErrorMessage(message)
    class UnknownError(message: String) : ErrorMessage(message)
}