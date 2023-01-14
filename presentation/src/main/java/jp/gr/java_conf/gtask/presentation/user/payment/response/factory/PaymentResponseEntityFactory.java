package jp.gr.java_conf.gtask.presentation.user.payment.response.factory;

import jp.gr.java_conf.gtask.presentation.user.payment.response.ErrorResponse;
import jp.gr.java_conf.gtask.presentation.user.payment.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentResponseEntityFactory {

    public ResponseEntity<PaymentResponse> create(PaymentResponse response) {
        return new ResponseEntity<>(
                response,
                resolvedHttpStatus(response.getError()));
    }

    HttpStatus resolvedHttpStatus(ErrorResponse errorResponse) {
        if (errorResponse == null) {
            return HttpStatus.OK;
        }

        return errorResponse.getHttpStatus();
    }
}
