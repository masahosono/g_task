package jp.gr.java_conf.gtask.presentation.user.transfer.response.factory;

import jp.gr.java_conf.gtask.presentation.user.transfer.response.ErrorResponse;
import jp.gr.java_conf.gtask.presentation.user.transfer.response.TransferResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransferResponseEntityFactory {

    public ResponseEntity<TransferResponse> create(TransferResponse response) {
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
