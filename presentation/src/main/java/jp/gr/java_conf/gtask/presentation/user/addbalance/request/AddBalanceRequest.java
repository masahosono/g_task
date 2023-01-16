package jp.gr.java_conf.gtask.presentation.user.addbalance.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class AddBalanceRequest {

    @Schema(description = "入金残高")
    @JsonProperty("balance")
    private long balance;

}
