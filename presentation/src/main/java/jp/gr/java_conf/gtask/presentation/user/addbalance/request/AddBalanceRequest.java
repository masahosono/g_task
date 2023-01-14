package jp.gr.java_conf.gtask.presentation.user.addbalance.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AddBalanceRequest {

    @JsonProperty("balance")
    private long balance;

}
