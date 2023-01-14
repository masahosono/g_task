package jp.gr.java_conf.gtask.presentation.user.payment.response.factory;

import jp.gr.java_conf.gtask.application.user.dto.PaymentResultDto;
import jp.gr.java_conf.gtask.presentation.user.payment.response.ErrorResponse;
import jp.gr.java_conf.gtask.presentation.user.payment.response.PaymentResponse;
import jp.gr.java_conf.gtask.presentation.user.payment.response.ResultResponse;
import jp.gr.java_conf.gtask.presentation.user.shared.HttpStatusCodeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentResponseFactory {

    private final HttpStatusCodeConverter httpStatusCodeConverter;

    public PaymentResponse createForSuccess(PaymentResultDto paymentResultDto) {
        return PaymentResponse.builder()
                .result(createResultResponse(paymentResultDto))
                .build();
    }

    ResultResponse createResultResponse(PaymentResultDto paymentResultDto) {
        return ResultResponse.builder()
                .userId(paymentResultDto.getUserId())
                .balance(paymentResultDto.getBalance())
                .build();
    }

    public PaymentResponse createForError(RuntimeException exception) {
        return PaymentResponse.builder()
                .error(createError(exception))
                .build();
    }

    ErrorResponse createError(RuntimeException exception) {
        return ErrorResponse.builder()
                .httpStatus(httpStatusCodeConverter.from(exception))
                .message(exception.getMessage())
                .build();
    }
}
