package jp.gr.java_conf.gtask.application.user;

import jp.gr.java_conf.gtask.application.user.dto.RegisterUserResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService {

    private final UserService userService;

    public RegisterUserResultDto registerUser() {
        System.out.println("hoge");
        long userId = userService.registerUser();
        return RegisterUserResultDto.of(1L); // TODO: 値は仮置き
    }
}
