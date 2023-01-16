package jp.gr.java_conf.gtask.presentation.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jp.gr.java_conf.gtask.application.user.AddBalanceService;
import jp.gr.java_conf.gtask.application.user.GetBalanceService;
import jp.gr.java_conf.gtask.application.user.GetHistoryService;
import jp.gr.java_conf.gtask.application.user.PaymentService;
import jp.gr.java_conf.gtask.application.user.RegisterUserService;
import jp.gr.java_conf.gtask.application.user.TransferService;
import jp.gr.java_conf.gtask.application.user.dto.AddBalanceArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.AddBalanceResultDto;
import jp.gr.java_conf.gtask.application.user.dto.GetBalanceArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.GetBalanceResultDto;
import jp.gr.java_conf.gtask.application.user.dto.GetHistoryArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.GetHistoryResultDto;
import jp.gr.java_conf.gtask.application.user.dto.PaymentArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.PaymentResultDto;
import jp.gr.java_conf.gtask.application.user.dto.RegisterUserArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.RegisterUserResultDto;
import jp.gr.java_conf.gtask.application.user.dto.TransferArgsDto;
import jp.gr.java_conf.gtask.application.user.dto.TransferResultDto;
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
import jp.gr.java_conf.gtask.presentation.user.gethistory.request.factory.GetHistoryArgsDtoFactory;
import jp.gr.java_conf.gtask.presentation.user.gethistory.response.GetHistoryResponse;
import jp.gr.java_conf.gtask.presentation.user.gethistory.response.factory.GetHistoryResponseEntityFactory;
import jp.gr.java_conf.gtask.presentation.user.gethistory.response.factory.GetHistoryResponseFactory;
import jp.gr.java_conf.gtask.presentation.user.payment.request.PaymentRequest;
import jp.gr.java_conf.gtask.presentation.user.payment.request.factory.PaymentArgsDtoFactory;
import jp.gr.java_conf.gtask.presentation.user.payment.response.PaymentResponse;
import jp.gr.java_conf.gtask.presentation.user.payment.response.factory.PaymentResponseEntityFactory;
import jp.gr.java_conf.gtask.presentation.user.payment.response.factory.PaymentResponseFactory;
import jp.gr.java_conf.gtask.presentation.user.registeruser.request.dto.factory.RegisterUserArgsDtoFactory;
import jp.gr.java_conf.gtask.presentation.user.registeruser.response.RegisterUserResponse;
import jp.gr.java_conf.gtask.presentation.user.registeruser.response.factory.RegisterUserResponseEntityFactory;
import jp.gr.java_conf.gtask.presentation.user.registeruser.response.factory.RegisterUserResponseFactory;
import jp.gr.java_conf.gtask.presentation.user.transfer.request.TransferRequest;
import jp.gr.java_conf.gtask.presentation.user.transfer.request.factory.TransferArgsDtoFactory;
import jp.gr.java_conf.gtask.presentation.user.transfer.response.TransferResponse;
import jp.gr.java_conf.gtask.presentation.user.transfer.response.factory.TransferResponseEntityFactory;
import jp.gr.java_conf.gtask.presentation.user.transfer.response.factory.TransferResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "独自コインAPI")
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

    // 支払いAPI
    private final PaymentService paymentService;
    private final PaymentArgsDtoFactory paymentArgsDtoFactory;
    private final PaymentResponseFactory paymentResponseFactory;
    private final PaymentResponseEntityFactory paymentResponseEntityFactory;

    // 送金API
    private final TransferService transferService;
    private final TransferArgsDtoFactory transferArgsDtoFactory;
    private final TransferResponseFactory transferResponseFactory;
    private final TransferResponseEntityFactory transferResponseEntityFactory;

    // 履歴API
    private final GetHistoryService getHistoryService;
    private final GetHistoryArgsDtoFactory getHistoryArgsDtoFactory;
    private final GetHistoryResponseFactory getHistoryResponseFactory;
    private final GetHistoryResponseEntityFactory getHistoryResponseEntityFactory;

    @Operation(summary = "ユーザ登録API", description = "独自コインを利用するためのユーザ登録をおこなう")
    @PostMapping(path = "/api/user", produces = "application/json")
    public ResponseEntity<RegisterUserResponse> registerUser(
            @Parameter(hidden = true) RequestDateTime requestDateTime) {
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

    @Operation(summary = "残高取得API", description = "ユーザーの残高を返却します")
    @GetMapping(path = "/api/user/{userId}/balance", produces = "application/json")
    public ResponseEntity<GetBalanceResponse> getBalance(
            @Schema(description = "ユーザID") @PathVariable("userId") long userId) {
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

    @Operation(summary = "入金API", description = "独自コインに入金をおこなう")
    @PostMapping(path = "/api/user/{userId}/balance", produces = "application/json")
    public ResponseEntity<AddBalanceResponse> addBalance(
            @RequestBody AddBalanceRequest requestBody,
            @Schema(description = "ユーザID") @PathVariable("userId") long userId,
            @Parameter(hidden = true) RequestDateTime requestDateTime) {
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

    @Operation(summary = "支払いAPI", description = "独自コインを使用して支払いをおこなう")
    @PostMapping(path = "/api/user/{userId}/payment", produces = "application/json")
    public ResponseEntity<?> payment(
            @RequestBody PaymentRequest requestBody,
            @Schema(description = "ユーザID") @PathVariable("userId") long userId,
            @Parameter(hidden = true) RequestDateTime requestDateTime) {
        PaymentResponse response;

        try {
            PaymentArgsDto paymentArgsDto =
                    paymentArgsDtoFactory.create(userId, requestBody, requestDateTime);

            PaymentResultDto paymentResultDto =
                    paymentService.payment(paymentArgsDto);
            response = paymentResponseFactory.createForSuccess(paymentResultDto);
        } catch (RuntimeException exception) {
            response = paymentResponseFactory.createForError(exception);
        }
        return paymentResponseEntityFactory.create(response);
    }

    @Operation(summary = "送金API", description = "他のユーザへ独自コインの送金をおこなう")
    @PostMapping(path = "/api/user/{userId}/transfer", produces = "application/json")
    public ResponseEntity<TransferResponse> transfer(
            @RequestBody TransferRequest requestBody,
            @Schema(description = "ユーザID") @PathVariable("userId") long userId,
            @Parameter(hidden = true) RequestDateTime requestDateTime) {
        TransferResponse response;

        try {
            TransferArgsDto transferArgsDto =
                    transferArgsDtoFactory.create(userId, requestBody, requestDateTime);

            TransferResultDto transferResultDto =
                    transferService.transfer(transferArgsDto);
            response = transferResponseFactory.createForSuccess(transferResultDto);
        } catch (RuntimeException exception) {
            response = transferResponseFactory.createForError(exception);
        }
        return transferResponseEntityFactory.create(response);
    }

    @Operation(summary = "履歴API", description = "出入金の履歴を取得する")
    @GetMapping(path = "/api/user/{userId}/history", produces = "application/json")
    public ResponseEntity<GetHistoryResponse> gethistory(
            @Schema(description = "ユーザID") @PathVariable("userId") long userId) {
        GetHistoryResponse response;

        try {
            GetHistoryArgsDto getHistoryArgsDto =
                    getHistoryArgsDtoFactory.create(userId);

            GetHistoryResultDto getHistoryResultDto =
                    getHistoryService.getHistory(getHistoryArgsDto);
            response = getHistoryResponseFactory.createForSuccess(getHistoryResultDto);
        } catch (RuntimeException exception) {
            response = getHistoryResponseFactory.createForError(exception);
        }
        return getHistoryResponseEntityFactory.create(response);
    }

}