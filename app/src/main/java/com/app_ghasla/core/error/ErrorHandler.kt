package com.app_ghasla.core.error

import com.app_ghasla.core.constant.emptyString
import com.google.firebase.FirebaseException

fun Throwable.toErrorMessage(): ErrorMessage {
    return runCatching {
        when (this) {
            is FirebaseException -> ErrorMessage.FirebaseError(message ?: emptyString)
            else -> ErrorMessage.UnknownError(message ?: emptyString)
        }
    }.getOrDefault(ErrorMessage.UnknownError(message ?: emptyString))
}