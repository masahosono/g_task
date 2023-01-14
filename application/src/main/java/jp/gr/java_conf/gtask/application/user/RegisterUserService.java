package jp.gr.java_conf.gtask.application.user;

import jp.gr.java_conf.gtask.application.user.dto.RegisterUserArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.RegisterUserResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService {

    private final UserService userService;

    public RegisterUserResultDto registerUser(
            RegisterUserArgsDto registerUserArgsDto) {
        long userId = userService.registerUser(
                registerUserArgsDto.getRequestDateTime());

        return RegisterUserResultDto.of(userId);
    }
}
