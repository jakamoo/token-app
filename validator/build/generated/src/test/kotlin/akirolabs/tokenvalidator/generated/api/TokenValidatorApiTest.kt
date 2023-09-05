package akirolabs.tokenvalidator.generated.api

import akirolabs.tokenvalidator.generated.model.Error
import akirolabs.tokenvalidator.generated.model.Token
import akirolabs.tokenvalidator.generated.model.ValidationResult
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class TokenValidatorApiTest {

    private val service: TokenValidatorApiService = TokenValidatorApiServiceImpl()
    private val api: TokenValidatorApiController = TokenValidatorApiController(service)

    /**
     * To test TokenValidatorApiController.validateToken
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun validateTokenTest() {
        val token: Token = TODO()
        val response: ResponseEntity<ValidationResult> = api.validateToken(token)

        // TODO: test validations
    }
}
