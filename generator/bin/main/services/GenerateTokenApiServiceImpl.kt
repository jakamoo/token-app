package akirolabs.tokengenerator.services

import akirolabs.tokengenerator.generated.api.GenerateTokenApiService
import akirolabs.tokengenerator.generated.model.Token
import akirolabs.tokengenerator.services.utility.Constants
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ControllerAdvice
import java.util.Random

@Service
@ControllerAdvice
class GenerateTokenApiServiceImpl : GenerateTokenApiService {

    private val random: Random = Random()



    override fun generateToken(requestBody: List<Int>): Token {
        val token = StringBuilder()
        for (i in 0 until Constants.TOKEN_LENGTH) {
            token.append(requestBody[random.nextInt(requestBody.size)])

            // Add dashes after every 4 characters for better readability
            if ((i + 1) % 4 == 0 && i != Constants.TOKEN_LENGTH - 1) {
                token.append('-')
            }
        }

        return Token(token.toString())
    }
}
