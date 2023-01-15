package jp.gr.java_conf.gtask.presentation.user.gethistory.response.factory;

import java.util.List;
import java.util.stream.Collectors;
import jp.gr.java_conf.gtask.application.user.dto.GetHistoryResultDto;
import jp.gr.java_conf.gtask.domain.user.UserHistoryList;
import jp.gr.java_conf.gtask.presentation.user.gethistory.response.ErrorResponse;
import jp.gr.java_conf.gtask.presentation.user.gethistory.response.GetHistoryResponse;
import jp.gr.java_conf.gtask.presentation.user.gethistory.response.HistoryResponse;
import jp.gr.java_conf.gtask.presentation.user.gethistory.response.ResultResponse;
import jp.gr.java_conf.gtask.presentation.user.shared.HttpStatusCodeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetHistoryResponseFactory {

    private final HttpStatusCodeConverter httpStatusCodeConverter;

    public GetHistoryResponse createForSuccess(GetHistoryResultDto getHistoryResultDto) {
        return GetHistoryResponse.builder()
                .result(createResultResponse(getHistoryResultDto))
                .build();
    }

    ResultResponse createResultResponse(GetHistoryResultDto getHistoryResultDto) {
        return ResultResponse.builder()
                .history(createHistory(getHistoryResultDto.getUserHistoryList()))
                .build();
    }

    List<HistoryResponse> createHistory(UserHistoryList userHistoryList) {
        return userHistoryList.getUserHistories().stream()
                .map(userHistory ->
                        HistoryResponse.builder()
                                .amount(userHistory.getAmount())
                                .balance(userHistory.getBalance())
                                .type(userHistory.getType())
                                .updateDate(userHistory.getUpdate_date().toString())
                                .build())
                .collect(
                        Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
    }

    public GetHistoryResponse createForError(RuntimeException exception) {
        return GetHistoryResponse.builder()
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
