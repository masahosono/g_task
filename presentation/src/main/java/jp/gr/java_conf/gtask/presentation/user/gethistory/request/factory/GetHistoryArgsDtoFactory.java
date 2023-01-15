package jp.gr.java_conf.gtask.presentation.user.gethistory.request.factory;

import jp.gr.java_conf.gtask.application.user.dto.GetHistoryArgsDto;
import org.springframework.stereotype.Component;

@Component
public class GetHistoryArgsDtoFactory {

    public GetHistoryArgsDto create(
            long userId) {

        return GetHistoryArgsDto.of(
                userId);
    }
}
