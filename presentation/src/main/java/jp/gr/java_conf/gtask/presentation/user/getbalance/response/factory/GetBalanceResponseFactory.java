package jp.gr.java_conf.gtask.presentation.user.getbalance.response.factory;

import jp.gr.java_conf.gtask.application.user.dto.GetBalanceResultDto;
import jp.gr.java_conf.gtask.presentation.user.getbalance.response.ErrorResponse;
import jp.gr.java_conf.gtask.presentation.user.getbalance.response.GetBalanceResponse;
import jp.gr.java_conf.gtask.presentation.user.getbalance.response.ResultResponse;
import jp.gr.java_conf.gtask.presentation.user.shared.HttpStatusCodeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetBalanceResponseFactory {

    private final HttpStatusCodeConverter httpStatusCodeConverter;

    public GetBalanceResponse createForSuccess(GetBalanceResultDto getBalanceResultDto) {
        return GetBalanceResponse.builder()
                .result(createResultResponse(getBalanceResultDto))
                .build();
    }

    ResultResponse createResultResponse(GetBalanceResultDto getBalanceResultDto) {
        return ResultResponse.builder()
                .userId(getBalanceResultDto.getUserId())
                .balance(getBalanceResultDto.getBalance())
                .build();
    }

    public GetBalanceResponse createForError(RuntimeException exception) {
        return GetBalanceResponse.builder()
                .error(createError(exception))
                .build();
    }

    ErrorResponse createError(RuntimeException exception) {
        // TODO: 対象リソースが未存在だった場合の例外に対し、HTTPステータス404を設定する。また、メッセージを整形する。
        return ErrorResponse.builder()
                .httpStatus(httpStatusCodeConverter.from(exception))
                .message(exception.getMessage())
                .build();
    }

}
