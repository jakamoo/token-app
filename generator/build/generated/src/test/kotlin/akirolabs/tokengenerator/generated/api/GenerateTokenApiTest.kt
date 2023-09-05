package akirolabs.tokengenerator.generated.api

import akirolabs.tokengenerator.generated.model.Error
import akirolabs.tokengenerator.generated.model.Token
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class GenerateTokenApiTest {

    private val service: GenerateTokenApiService = GenerateTokenApiServiceImpl()
    private val api: GenerateTokenApiController = GenerateTokenApiController(service)

    /**
     * To test GenerateTokenApiController.generateToken
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun generateTokenTest() {
        val requestBody: kotlin.collections.List<kotlin.Int> = TODO()
        val response: ResponseEntity<Token> = api.generateToken(requestBody)

        // TODO: test validations
    }
}
