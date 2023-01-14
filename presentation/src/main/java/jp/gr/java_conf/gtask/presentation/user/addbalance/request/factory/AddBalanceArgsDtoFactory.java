package jp.gr.java_conf.gtask.presentation.user.addbalance.request.factory;

import jp.gr.java_conf.gtask.application.user.dto.AddBalanceArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.GetBalanceArgsDto;
import jp.gr.java_conf.gtask.domain.datetime.RequestDateTime;
import jp.gr.java_conf.gtask.presentation.user.addbalance.request.AddBalanceRequest;
import org.springframework.stereotype.Component;

@Component
public class AddBalanceArgsDtoFactory {

    public AddBalanceArgsDto create(
            long userId,
            AddBalanceRequest addBalanceRequest,
            RequestDateTime requestDateTime) {

        return AddBalanceArgsDto.of(
                userId,
                addBalanceRequest.getBalance(),
                requestDateTime);
    }
}
