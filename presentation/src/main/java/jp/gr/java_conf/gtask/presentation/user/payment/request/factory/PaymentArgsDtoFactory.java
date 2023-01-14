package jp.gr.java_conf.gtask.presentation.user.payment.request.factory;

import jp.gr.java_conf.gtask.application.user.dto.PaymentArgsDto;
import jp.gr.java_conf.gtask.domain.datetime.RequestDateTime;
import jp.gr.java_conf.gtask.presentation.user.payment.request.PaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class PaymentArgsDtoFactory {

    public PaymentArgsDto create(
            long userId,
            PaymentRequest paymentRequest,
            RequestDateTime requestDateTime) {

        return PaymentArgsDto.of(
                userId,
                paymentRequest.getBalance(),
                requestDateTime);
    }
}
