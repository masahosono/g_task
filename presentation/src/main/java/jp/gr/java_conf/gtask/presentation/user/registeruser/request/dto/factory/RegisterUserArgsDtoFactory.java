package jp.gr.java_conf.gtask.presentation.user.registeruser.request.dto.factory;

import jp.gr.java_conf.gtask.application.user.dto.RegisterUserArgsDto;
import jp.gr.java_conf.gtask.domain.datetime.RequestDateTime;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserArgsDtoFactory {

    public RegisterUserArgsDto create(
            RequestDateTime requestDateTime) {

        return RegisterUserArgsDto.of(
                requestDateTime
        );
    }
}
