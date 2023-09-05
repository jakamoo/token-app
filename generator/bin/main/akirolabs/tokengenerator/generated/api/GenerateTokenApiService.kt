package akirolabs.tokengenerator.generated.api

import akirolabs.tokengenerator.generated.model.Error
import akirolabs.tokengenerator.generated.model.Token
    interface GenerateTokenApiService {

        fun generateToken(requestBody: kotlin.collections.List<kotlin.Int>): Token
    }
