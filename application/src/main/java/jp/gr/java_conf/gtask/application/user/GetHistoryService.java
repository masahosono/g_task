package jp.gr.java_conf.gtask.application.user;

import jp.gr.java_conf.gtask.application.user.dto.GetHistoryArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.GetHistoryResultDto;
import jp.gr.java_conf.gtask.domain.user.UserHistoryList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetHistoryService {

    private final UserService userService;

    public GetHistoryResultDto getHistory(
            GetHistoryArgsDto getHistoryArgsDto) {
        UserHistoryList userHistoryList = userService.getHistory(
                getHistoryArgsDto.getUserId());

        return GetHistoryResultDto.of(userHistoryList);
    }
}
