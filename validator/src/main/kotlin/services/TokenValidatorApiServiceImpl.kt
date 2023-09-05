package akirolabs.tokenvalidator.services

import akirolabs.tokenvalidator.generated.api.TokenValidatorApiService
import akirolabs.tokenvalidator.generated.model.Token
import akirolabs.tokenvalidator.generated.model.ValidationResult
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ControllerAdvice

@Service
@ControllerAdvice
class TokenValidatorApiServiceImpl : TokenValidatorApiService {




    override fun validateToken(token: Token): ValidationResult {

        val sanitizedToken = token.token?.replace("-".toRegex(), "")
        return ValidationResult(sanitizedToken?.let { luhnCheck(it) })
    }

    private fun luhnCheck(number: String): Boolean {
        println(number)
        var sum = 0
        var alternate = false
        for (i in number.length - 1 downTo 0) {
            var n = number.substring(i, i + 1).toInt()
            if (alternate) {
                n *= 2
                if (n > 9) {
                    n -= 9
                }
            }
            sum += n
            alternate = !alternate
        }
        return sum % 10 == 0
    }
}
