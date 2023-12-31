package akirolabs.tokengenerator.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
* 
    * @param code 
    * @param message 
    * @param description 
    * @param source 
    * @param errors 
*/
data class FaultDefinition(
        
    


    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("code", required = true) val code: kotlin.Int,
            
    


    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("message", required = true) val message: kotlin.String,
            
    


    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("description", required = true) val description: kotlin.String,
    
    


    @Schema(example = "null", description = "")
    @get:JsonProperty("source") val source: kotlin.String? = null,
    
    


    @Schema(example = "null", description = "")
    @get:JsonProperty("errors") val errors: kotlin.collections.List<kotlin.Int>? = null
) {

}

