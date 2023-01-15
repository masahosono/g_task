package jp.gr.java_conf.gtask.application.user.dto;

import jp.gr.java_conf.gtask.domain.user.UserHistoryList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class GetHistoryResultDto {

    private final UserHistoryList userHistoryList;
}
