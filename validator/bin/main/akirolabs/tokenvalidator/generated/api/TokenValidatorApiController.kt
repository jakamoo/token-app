package akirolabs.tokenvalidator.generated.api

import akirolabs.tokenvalidator.generated.model.Error
import akirolabs.tokenvalidator.generated.model.Token
import akirolabs.tokenvalidator.generated.model.ValidationResult
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
class TokenValidatorApiController(@Autowired(required = true) val service: TokenValidatorApiService) {

    @Operation(
        summary = "Validate a token.",
        operationId = "validateToken",
        description = """Validates a given token using the luhnCheck after sanitizing.""",
        responses = [
            ApiResponse(responseCode = "200", description = "Token validation result", content = [Content(schema = Schema(implementation = ValidationResult::class))]),
            ApiResponse(responseCode = "401", description = "Authentication information is missing or invalid"),
            ApiResponse(responseCode = "403", description = "Forbidden", content = [Content(schema = Schema(implementation = Error::class))]),
            ApiResponse(responseCode = "404", description = "The specified resource was not found", content = [Content(schema = Schema(implementation = Error::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/validateToken"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun validateToken(@Parameter(description = "Token to be validated", required = true) @Valid @RequestBody token: Token
): ResponseEntity<ValidationResult> {
        return ResponseEntity(service.validateToken(token), HttpStatus.valueOf(200))
    }
}
