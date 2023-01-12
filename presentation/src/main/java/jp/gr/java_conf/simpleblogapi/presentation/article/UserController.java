package jp.gr.java_conf.simpleblogapi.presentation.article;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequiredArgsConstructor
public class UserController {

    @PostMapping(path = "/api/user", produces = "application/json")
    public ResponseEntity<?> registerUser() {
        return new ResponseEntity<Void>(null);
    }

}