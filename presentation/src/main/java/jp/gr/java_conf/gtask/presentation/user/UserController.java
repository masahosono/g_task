package jp.gr.java_conf.gtask.presentation.user;

import jp.gr.java_conf.gtask.application.user.RegisterUserService;
import jp.gr.java_conf.gtask.application.user.dto.RegisterUserArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.RegisterUserResultDto;
import jp.gr.java_conf.gtask.domain.datetime.RequestDateTime;
import jp.gr.java_conf.gtask.presentation.user.registeruser.request.dto.factory.RegisterUserArgsDtoFactory;
import jp.gr.java_conf.gtask.presentation.user.registeruser.response.RegisterUserResponse;
import jp.gr.java_conf.gtask.presentation.user.registeruser.response.factory.RegisterUserResponseEntityFactory;
import jp.gr.java_conf.gtask.presentation.user.registeruser.response.factory.RegisterUserResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserService registerUserService;
    private final RegisterUserArgsDtoFactory registerUserArgsDtoFactory;
    private final RegisterUserResponseFactory registerUserResponseFactory;
    private final RegisterUserResponseEntityFactory registerUserResponseEntityFactory;

    @PostMapping(path = "/api/user", produces = "application/json")
    public ResponseEntity<RegisterUserResponse> registerUser(
            RequestDateTime requestDateTime) {
        RegisterUserResponse response;

        try {
            RegisterUserArgsDto registerUserArgsDto =
                    registerUserArgsDtoFactory.create(requestDateTime);

            RegisterUserResultDto registerUserResultDto =
                    registerUserService.registerUser(registerUserArgsDto);
            response = registerUserResponseFactory.createForSuccess(registerUserResultDto.getUserId());
        } catch (RuntimeException exception) {
            response = registerUserResponseFactory.createForError(exception);
        }
        return registerUserResponseEntityFactory.create(response);
    }

    @GetMapping(path = "/api/user/{userId}/balance", produces = "application/json")
    public ResponseEntity<?> getBalance(
            @PathVariable("userId") String userId) {
        return new ResponseEntity<Void>(null);
    }

    @PostMapping(path = "/api/user/{userId}/balance", produces = "application/json")
    public ResponseEntity<?> addBalance(
            @PathVariable("userId") String userId) {
        return new ResponseEntity<Void>(null);
    }

    @PostMapping(path = "/api/user/{userId}/payment", produces = "application/json")
    public ResponseEntity<?> payment(
            @PathVariable("userId") String userId) {
        return new ResponseEntity<Void>(null);
    }

    @PostMapping(path = "/api/user/{userId}/transfer", produces = "application/json")
    public ResponseEntity<?> transfer(
            @PathVariable("userId") String userId) {
        return new ResponseEntity<Void>(null);
    }

    @PostMapping(path = "/api/user/{userId}/history", produces = "application/json")
    public ResponseEntity<?> gethistory(
            @PathVariable("userId") String userId) {
        return new ResponseEntity<Void>(null);
    }

}