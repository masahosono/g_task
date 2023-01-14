package jp.gr.java_conf.gtask.presentation.user.addbalance.response.factory;

import jp.gr.java_conf.gtask.presentation.user.addbalance.response.ErrorResponse;
import jp.gr.java_conf.gtask.presentation.user.addbalance.response.AddBalanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddBalanceResponseEntityFactory {

    public ResponseEntity<AddBalanceResponse> create(AddBalanceResponse response) {
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
