package com.torsoft.clevertodo.ui.validator.base

interface ValidationResult {

    object Success : ValidationResult

    data class Failure(val messageResourceId: Int) : ValidationResult

}

inline fun ValidationResult.onSuccess(action: () -> Unit): ValidationResult {
    if (this is ValidationResult.Success) {
        action.invoke()
    }
    return this
}

inline fun ValidationResult.onFailure(action: (Int) -> Unit): ValidationResult {
    if (this is ValidationResult.Failure) {
        action.invoke(this.messageResourceId)
    }
    return this
}

inline fun <R> ValidationResult.fold(
    onSuccess: () -> R,
    onFailure: (Int) -> R,
): R {
    return when (this) {
        is ValidationResult.Failure -> onFailure(messageResourceId)
        else -> onSuccess()
    }
}
