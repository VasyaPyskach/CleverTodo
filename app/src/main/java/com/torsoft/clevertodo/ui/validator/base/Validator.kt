package com.torsoft.clevertodo.ui.validator.base

interface Validator<T> {

    fun validate(value: T): ValidationResult

}
