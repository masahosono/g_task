package jp.gr.java_conf.gtask.presentation.user.transfer.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class TransferRequest {

    @Schema(description = "送金先ユーザID")
    @JsonProperty("recipientUserId")
    private long recipientUserId;

    @Schema(description = "送金残高")
    @JsonProperty("balance")
    private long balance;

}
