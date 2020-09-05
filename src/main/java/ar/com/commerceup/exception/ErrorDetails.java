package ar.com.commerceup.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@JsonInclude(content = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ErrorDetails {
    private String errorCode;
    private String message;
 
    public ErrorDetails(String errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
    }
    
}
