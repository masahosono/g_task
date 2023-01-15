package jp.gr.java_conf.gtask.application.user;

import jp.gr.java_conf.gtask.application.user.dto.TransferArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.TransferResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final UserService userService;

    public TransferResultDto transfer(
            TransferArgsDto transferArgsDto) {
        long balance = userService.transfer(
                transferArgsDto.getSenderUserId(),
                transferArgsDto.getRecipientUserId(),
                transferArgsDto.getBalance(),
                transferArgsDto.getRequestDateTime());

        return TransferResultDto.of(
                transferArgsDto.getSenderUserId(),
                balance);
    }
}
