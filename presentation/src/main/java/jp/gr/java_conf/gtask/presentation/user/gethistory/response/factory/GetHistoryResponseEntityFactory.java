package jp.gr.java_conf.gtask.presentation.user.gethistory.response.factory;

import jp.gr.java_conf.gtask.presentation.user.gethistory.response.ErrorResponse;
import jp.gr.java_conf.gtask.presentation.user.gethistory.response.GetHistoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetHistoryResponseEntityFactory {

    public ResponseEntity<GetHistoryResponse> create(GetHistoryResponse response) {
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
