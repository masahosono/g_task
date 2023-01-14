package jp.gr.java_conf.gtask.presentation.user.payment.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PaymentRequest {

    @JsonProperty("balance")
    private long balance;

}
