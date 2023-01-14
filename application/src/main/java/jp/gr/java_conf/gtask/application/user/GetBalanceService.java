package jp.gr.java_conf.gtask.application.user;

import jp.gr.java_conf.gtask.application.user.dto.GetBalanceArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.GetBalanceResultDto;
import jp.gr.java_conf.gtask.application.user.dto.RegisterUserArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.RegisterUserResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetBalanceService {

    private final UserService userService;

    public GetBalanceResultDto getBalance(
            GetBalanceArgsDto getBalanceArgsDto) {
        long balance = userService.getBalance(
                getBalanceArgsDto.getUserId());

        return GetBalanceResultDto.of(
                getBalanceArgsDto.getUserId(),
                balance);
    }
}
