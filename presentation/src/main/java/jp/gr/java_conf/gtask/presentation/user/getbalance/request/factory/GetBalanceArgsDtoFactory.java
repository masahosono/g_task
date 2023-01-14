package jp.gr.java_conf.gtask.presentation.user.getbalance.request.factory;

import jp.gr.java_conf.gtask.application.user.dto.GetBalanceArgsDto;
import org.springframework.stereotype.Component;

@Component
public class GetBalanceArgsDtoFactory {

    public GetBalanceArgsDto create(
            long userId) {

        return GetBalanceArgsDto.of(
                userId);
    }
}
