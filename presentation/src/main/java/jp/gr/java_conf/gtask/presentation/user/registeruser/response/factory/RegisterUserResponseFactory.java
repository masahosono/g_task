package jp.gr.java_conf.gtask.presentation.user.registeruser.response.factory;

import jp.gr.java_conf.gtask.presentation.user.registeruser.response.ErrorResponse;
import jp.gr.java_conf.gtask.presentation.user.registeruser.response.RegisterUserResponse;
import jp.gr.java_conf.gtask.presentation.user.registeruser.response.ResultResponse;
import jp.gr.java_conf.gtask.presentation.user.shared.HttpStatusCodeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserResponseFactory {

    private final HttpStatusCodeConverter httpStatusCodeConverter;

    public RegisterUserResponse createForSuccess(long userId) {
        return RegisterUserResponse.builder()
                .result(createResultResponse(userId))
                .build();
    }

    ResultResponse createResultResponse(long userId) {
        return ResultResponse.builder()
                .userId(userId)
                .build();
    }

    public RegisterUserResponse createForError(RuntimeException exception) {
        return RegisterUserResponse.builder()
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
