package jp.gr.java_conf.gtask.presentation.user.getBalance.response.factory;

import jp.gr.java_conf.gtask.presentation.user.getBalance.response.ErrorResponse;
import jp.gr.java_conf.gtask.presentation.user.getBalance.response.GetBalanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetBalanceResponseEntityFactory {

    public ResponseEntity<GetBalanceResponse> create(GetBalanceResponse response) {
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
