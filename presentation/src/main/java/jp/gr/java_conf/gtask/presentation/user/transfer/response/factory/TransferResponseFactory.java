package jp.gr.java_conf.gtask.presentation.user.transfer.response.factory;

import jp.gr.java_conf.gtask.application.user.dto.TransferResultDto;
import jp.gr.java_conf.gtask.presentation.user.shared.HttpStatusCodeConverter;
import jp.gr.java_conf.gtask.presentation.user.transfer.response.ErrorResponse;
import jp.gr.java_conf.gtask.presentation.user.transfer.response.TransferResponse;
import jp.gr.java_conf.gtask.presentation.user.transfer.response.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransferResponseFactory {

    private final HttpStatusCodeConverter httpStatusCodeConverter;

    public TransferResponse createForSuccess(TransferResultDto transferResultDto) {
        return TransferResponse.builder()
                .result(createResultResponse(transferResultDto))
                .build();
    }

    ResultResponse createResultResponse(TransferResultDto transferResultDto) {
        return ResultResponse.builder()
                .userId(transferResultDto.getUserId())
                .balance(transferResultDto.getBalance())
                .build();
    }

    public TransferResponse createForError(RuntimeException exception) {
        return TransferResponse.builder()
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
