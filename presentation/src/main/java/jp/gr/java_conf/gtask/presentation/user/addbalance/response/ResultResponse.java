package jp.gr.java_conf.gtask.presentation.user.addbalance.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jp.gr.java_conf.gtask.presentation.user.registeruser.response.ErrorResponse;
import lombok.Builder;

@Builder
public class ResultResponse {

    @Schema(description = "ユーザID")
    @JsonProperty("userId")
    private long userId;

    @Schema(description = "残高")
    @JsonProperty("balance")
    private long balance;
}
