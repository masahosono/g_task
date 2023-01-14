package jp.gr.java_conf.gtask.presentation.user.registeruser.response.factory;

import jp.gr.java_conf.gtask.presentation.user.registeruser.response.ErrorResponse;
import jp.gr.java_conf.gtask.presentation.user.registeruser.response.RegisterUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserResponseEntityFactory {

    public ResponseEntity<RegisterUserResponse> create(RegisterUserResponse response) {
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
