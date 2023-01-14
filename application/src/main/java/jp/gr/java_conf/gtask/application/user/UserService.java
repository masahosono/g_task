package jp.gr.java_conf.gtask.application.user;

import jp.gr.java_conf.gtask.application.user.dto.GetBalanceArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.RegisterUserArgsDto;
import jp.gr.java_conf.gtask.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public long registerUser(RegisterUserArgsDto registerUserArgsDto) {
        return userRepository.registerUser(
                registerUserArgsDto.getRequestDateTime().getValue());
    }

    public long getBalance(GetBalanceArgsDto getBalanceArgsDto) {
        return userRepository.getBalance(
                getBalanceArgsDto.getUserId());
    }

}
