package jp.gr.java_conf.gtask.presentation.user.getBalance.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ResultResponse {

    @JsonProperty("userId")
    private long userId;

    @JsonProperty("balance")
    private long balance;
}
