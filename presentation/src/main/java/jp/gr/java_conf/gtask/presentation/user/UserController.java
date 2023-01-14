package jp.gr.java_conf.gtask.presentation.user;

import jp.gr.java_conf.gtask.application.user.AddBalanceService;
import jp.gr.java_conf.gtask.application.user.GetBalanceService;
import jp.gr.java_conf.gtask.application.user.RegisterUserService;
import jp.gr.java_conf.gtask.application.user.dto.AddBalanceArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.AddBalanceResultDto;
import jp.gr.java_conf.gtask.application.user.dto.GetBalanceArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.GetBalanceResultDto;
import jp.gr.java_conf.gtask.application.user.dto.RegisterUserArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.RegisterUserResultDto;
import jp.gr.java_conf.gtask.domain.datetime.RequestDateTime;
import jp.gr.java_conf.gtask.presentation.user.addbalance.request.AddBalanceRequest;
import jp.gr.java_conf.gtask.presentation.user.addbalance.request.factory.AddBalanceArgsDtoFactory;
import jp.gr.java_conf.gtask.presentation.user.addbalance.response.AddBalanceResponse;
import jp.gr.java_conf.gtask.presentation.user.addbalance.response.factory.AddBalanceResponseEntityFactory;
import jp.gr.java_conf.gtask.presentation.user.addbalance.response.factory.AddBalanceResponseFactory;
import jp.gr.java_conf.gtask.presentation.user.getbalance.request.factory.GetBalanceArgsDtoFactory;
import jp.gr.java_conf.gtask.presentation.user.getbalance.response.GetBalanceResponse;
import jp.gr.java_conf.gtask.presentation.user.getbalance.response.factory.GetBalanceResponseEntityFactory;
import jp.gr.java_conf.gtask.presentation.user.getbalance.response.factory.GetBalanceResponseFactory;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequiredArgsConstructor
public class UserController {

    // TODO: 依存するBeanが多いため、Controllerクラスの分割を検討。

    // ユーザ登録API
    private final RegisterUserService registerUserService;
    private final RegisterUserArgsDtoFactory registerUserArgsDtoFactory;
    private final RegisterUserResponseFactory registerUserResponseFactory;
    private final RegisterUserResponseEntityFactory registerUserResponseEntityFactory;

    // 残高取得API
    private final GetBalanceService getBalanceService;
    private final GetBalanceArgsDtoFactory getBalanceArgsDtoFactory;
    private final GetBalanceResponseFactory getBalanceResponseFactory;
    private final GetBalanceResponseEntityFactory getBalanceResponseEntityFactory;

    // 残高追加API
    private final AddBalanceService addBalanceService;
    private final AddBalanceArgsDtoFactory addBalanceArgsDtoFactory;
    private final AddBalanceResponseFactory addBalanceResponseFactory;
    private final AddBalanceResponseEntityFactory addBalanceResponseEntityFactory;

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
    public ResponseEntity<GetBalanceResponse> getBalance(
            @PathVariable("userId") long userId) {
        GetBalanceResponse response;

        try {
            GetBalanceArgsDto getBalanceArgsDto =
                    getBalanceArgsDtoFactory.create(userId);

            GetBalanceResultDto getBalanceResultDto =
                    getBalanceService.getBalance(getBalanceArgsDto);
            response = getBalanceResponseFactory.createForSuccess(getBalanceResultDto);
        } catch (RuntimeException exception) {
            response = getBalanceResponseFactory.createForError(exception);
        }
        return getBalanceResponseEntityFactory.create(response);
    }

    @PostMapping(path = "/api/user/{userId}/balance", produces = "application/json")
    public ResponseEntity<AddBalanceResponse> addBalance(
            @RequestBody AddBalanceRequest requestBody,
            @PathVariable("userId") long userId,
            RequestDateTime requestDateTime) {
        AddBalanceResponse response;

        try {
            AddBalanceArgsDto addBalanceArgsDto =
                    addBalanceArgsDtoFactory.create(userId, requestBody, requestDateTime);

            AddBalanceResultDto addBalanceResultDto =
                    addBalanceService.addBalance(addBalanceArgsDto);
            response = addBalanceResponseFactory.createForSuccess(addBalanceResultDto);
        } catch (RuntimeException exception) {
            response = addBalanceResponseFactory.createForError(exception);
        }
        return addBalanceResponseEntityFactory.create(response);
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