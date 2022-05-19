package com.torsoft.clevertodo.ui.validator

import com.torsoft.clevertodo.R
import com.torsoft.clevertodo.ui.validator.base.ValidationResult
import com.torsoft.clevertodo.ui.validator.base.Validator

class DomainValidator: Validator<String> {

    override fun validate(value: String): ValidationResult {
        return if(value.isNotEmpty()){
            ValidationResult.Success
        }else{
            ValidationResult.Failure(R.string.login_empty_domain_error)
        }
    }

}
