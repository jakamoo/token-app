package akirolabs.tokenvalidator.generated.api

import akirolabs.tokenvalidator.generated.model.Error
import akirolabs.tokenvalidator.generated.model.Token
import akirolabs.tokenvalidator.generated.model.ValidationResult
    interface TokenValidatorApiService {

        fun validateToken(token: Token): ValidationResult
    }
