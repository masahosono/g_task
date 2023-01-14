package jp.gr.java_conf.gtask.presentation.user.getBalance.factory;

import jp.gr.java_conf.gtask.application.user.dto.GetBalanceArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.RegisterUserArgsDto;
import jp.gr.java_conf.gtask.domain.datetime.RequestDateTime;
import org.springframework.stereotype.Component;

@Component
public class GetBalanceArgsDtoFactory {

    public GetBalanceArgsDto create(
            long userId) {

        return GetBalanceArgsDto.of(
                userId);
    }
}
