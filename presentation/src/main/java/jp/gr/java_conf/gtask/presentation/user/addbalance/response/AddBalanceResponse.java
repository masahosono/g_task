package jp.gr.java_conf.gtask.presentation.user.addbalance.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddBalanceResponse {

    @JsonProperty("result")
    private ResultResponse result;

    @JsonProperty("error")
    private ErrorResponse error;
}
