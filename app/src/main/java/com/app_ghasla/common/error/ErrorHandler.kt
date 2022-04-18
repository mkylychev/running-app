package com.app_ghasla.common.error

import com.app_ghasla.common.constant.emptyString
import com.google.firebase.FirebaseException

fun Throwable.toErrorMessage(): ErrorMessage {
    return runCatching {
        when (this) {
            is FirebaseException -> ErrorMessage.FirebaseError(message ?: emptyString)
            else -> ErrorMessage.UnknownError(message ?: emptyString)
        }
    }.getOrDefault(ErrorMessage.UnknownError(message ?: emptyString))
}