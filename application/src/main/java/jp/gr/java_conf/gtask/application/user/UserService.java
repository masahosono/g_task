package jp.gr.java_conf.gtask.application.user;

import jp.gr.java_conf.gtask.domain.datetime.RequestDateTime;
import jp.gr.java_conf.gtask.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public long registerUser(
            RequestDateTime requestDateTime) {
        return userRepository.registerUser(
                requestDateTime.getValue());
    }

    public long getBalance(
            long userId) {
        return userRepository.getBalance(
                userId);
    }

    public long addBalance(
            long userId,
            long balance,
            RequestDateTime requestDateTime) {
        return userRepository.addBalance(
                userId,
                balance,
                requestDateTime.getValue());
    }

}
