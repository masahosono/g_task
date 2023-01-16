package jp.gr.java_conf.gtask.presentation.user.gethistory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;

@Builder
public class ResultResponse {

    @Schema(description = "ユーザ残高履歴")
    @JsonProperty("history")
    private List<HistoryResponse> history;

}
