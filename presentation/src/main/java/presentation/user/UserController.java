package presentation.user;

import application.user.RegisterUserService;
import application.user.dto.RegisterUserResultDto;
import presentation.user.registeruser.response.RegisterUserResponse;
import presentation.user.registeruser.response.factory.RegisterUserResponseEntityFactory;
import presentation.user.registeruser.response.factory.RegisterUserResponseFactory;
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

    RegisterUserService registerUserService;
    RegisterUserResponseFactory registerUserResponseFactory;
    RegisterUserResponseEntityFactory registerUserResponseEntityFactory;

    @PostMapping(path = "/api/user", produces = "application/json")
    public ResponseEntity<?> registerUser() {
        RegisterUserResponse response;

        try {
            RegisterUserResultDto registerUserResultDto = registerUserService.registerUser();
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