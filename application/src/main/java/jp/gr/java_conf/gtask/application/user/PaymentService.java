package jp.gr.java_conf.gtask.application.user;

import jp.gr.java_conf.gtask.application.user.dto.PaymentArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.PaymentResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final UserService userService;

    public PaymentResultDto payment(
            PaymentArgsDto paymentArgsDto) {

        long balance = userService.payment(
                paymentArgsDto.getUserId(),
                paymentArgsDto.getBalance(),
                paymentArgsDto.getRequestDateTime());

        return PaymentResultDto.of(
                paymentArgsDto.getUserId(),
                balance);
    }
}
