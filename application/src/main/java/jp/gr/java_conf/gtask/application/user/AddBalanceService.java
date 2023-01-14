package jp.gr.java_conf.gtask.application.user;

import jp.gr.java_conf.gtask.application.user.dto.AddBalanceArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.AddBalanceResultDto;
import jp.gr.java_conf.gtask.application.user.dto.GetBalanceArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.GetBalanceResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddBalanceService {

    private final UserService userService;

    public AddBalanceResultDto addBalance(
            AddBalanceArgsDto addBalanceArgsDto) {
        long balance = userService.addBalance(
                addBalanceArgsDto.getUserId(),
                addBalanceArgsDto.getBalance(),
                addBalanceArgsDto.getRequestDateTime());

        return AddBalanceResultDto.of(
                addBalanceArgsDto.getUserId(),
                balance);
    }
}
