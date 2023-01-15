package jp.gr.java_conf.gtask.presentation.user.gethistory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class HistoryResponse {

    @JsonProperty("amount")
    private long amount;

    @JsonProperty("type")
    private String type;

    @JsonProperty("balance")
    private long balance;

    @JsonProperty("updateDate")
    private String updateDate;
}
