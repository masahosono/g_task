package jp.gr.java_conf.gtask.presentation.user.addbalance.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
public class ErrorResponse {

    @Getter
    @JsonIgnore
    private final HttpStatus httpStatus;

    @JsonProperty("message")
    private final String message;
}
