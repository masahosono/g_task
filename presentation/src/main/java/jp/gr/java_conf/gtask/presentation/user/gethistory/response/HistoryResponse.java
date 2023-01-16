package jp.gr.java_conf.gtask.presentation.user.gethistory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public class HistoryResponse {

    @Schema(description = "出入金額")
    @JsonProperty("amount")
    private long amount;

    @Schema(description = "出入金種別 in: 入金、out: 出金")
    @JsonProperty("type")
    private String type;

    @Schema(description = "残高")
    @JsonProperty("balance")
    private long balance;

    @Schema(description = "更新日時")
    @JsonProperty("updateDate")
    private String updateDate;
}
