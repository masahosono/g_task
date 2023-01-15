package jp.gr.java_conf.gtask.presentation.user.transfer.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TransferRequest {

    @JsonProperty("recipientUserId")
    private long recipientUserId;

    @JsonProperty("balance")
    private long balance;

}
