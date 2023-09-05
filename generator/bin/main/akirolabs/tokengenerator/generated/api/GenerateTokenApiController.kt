package akirolabs.tokengenerator.generated.api

import akirolabs.tokengenerator.generated.model.Error
import akirolabs.tokengenerator.generated.model.Token
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

import kotlin.collections.List
import kotlin.collections.Map

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class GenerateTokenApiController(@Autowired(required = true) val service: GenerateTokenApiService) {

    @Operation(
        summary = "Generate a token.",
        operationId = "generateToken",
        description = """Generates a token with given available digits.""",
        responses = [
            ApiResponse(responseCode = "200", description = "Generated token", content = [Content(schema = Schema(implementation = Token::class))]),
            ApiResponse(responseCode = "401", description = "Authentication information is missing or invalid"),
            ApiResponse(responseCode = "403", description = "Forbidden", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "404", description = "The specified resource was not found", content = [Content(schema = Schema(implementation = Error::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/generateToken"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun generateToken(@Parameter(description = "Token to be generated", required = true) @Valid @RequestBody requestBody: kotlin.collections.List<kotlin.Int>
): ResponseEntity<Token> {
        return ResponseEntity(service.generateToken(requestBody), HttpStatus.valueOf(200))
    }
}
