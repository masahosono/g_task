package jp.gr.java_conf.gtask.presentation.user.gethistory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;

@Builder
public class ResultResponse {

    @JsonProperty("history")
    private List<HistoryResponse> history;

}
