package jp.gr.java_conf.gtask.presentation.user.getbalance.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetBalanceResponse {

    @Schema(description = "成功時レスポンス")
    @JsonProperty("result")
    private ResultResponse result;

    @Schema(description = "失敗時レスポンス")
    @JsonProperty("error")
    private ErrorResponse error;
}
