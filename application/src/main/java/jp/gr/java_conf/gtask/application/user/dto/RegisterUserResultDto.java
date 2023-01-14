package jp.gr.java_conf.gtask.application.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class RegisterUserResultDto {

    private final long userId;

}
