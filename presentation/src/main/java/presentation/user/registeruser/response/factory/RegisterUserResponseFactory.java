package presentation.user.registeruser.response.factory;

import presentation.user.registeruser.response.ErrorResponse;
import presentation.user.registeruser.response.RegisterUserResponse;
import presentation.user.registeruser.response.ResultResponse;
import presentation.user.shared.HttpStatusCodeConverter;
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
