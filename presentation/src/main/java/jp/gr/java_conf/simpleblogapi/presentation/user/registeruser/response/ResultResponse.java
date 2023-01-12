package jp.gr.java_conf.simpleblogapi.presentation.user.registeruser.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ResultResponse {

    @JsonProperty("userId")
    private long userId;
}
