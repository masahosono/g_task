package jp.gr.java_conf.gtask.presentation.user.addbalance.response.factory;

import jp.gr.java_conf.gtask.application.user.dto.AddBalanceResultDto;
import jp.gr.java_conf.gtask.presentation.user.addbalance.response.AddBalanceResponse;
import jp.gr.java_conf.gtask.presentation.user.addbalance.response.ErrorResponse;
import jp.gr.java_conf.gtask.presentation.user.addbalance.response.ResultResponse;
import jp.gr.java_conf.gtask.presentation.user.shared.HttpStatusCodeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddBalanceResponseFactory {

    private final HttpStatusCodeConverter httpStatusCodeConverter;

    public AddBalanceResponse createForSuccess(AddBalanceResultDto addBalanceResultDto) {
        return AddBalanceResponse.builder()
                .result(createResultResponse(addBalanceResultDto))
                .build();
    }

    ResultResponse createResultResponse(AddBalanceResultDto addBalanceResultDto) {
        return ResultResponse.builder()
                .userId(addBalanceResultDto.getUserId())
                .balance(addBalanceResultDto.getBalance())
                .build();
    }

    public AddBalanceResponse createForError(RuntimeException exception) {
        return AddBalanceResponse.builder()
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
