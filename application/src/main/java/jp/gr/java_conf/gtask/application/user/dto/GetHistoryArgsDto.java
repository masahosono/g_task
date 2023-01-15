package jp.gr.java_conf.gtask.application.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class GetHistoryArgsDto {

    private final long userId;

}
