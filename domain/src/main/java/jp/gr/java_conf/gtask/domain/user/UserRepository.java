package jp.gr.java_conf.gtask.domain.user;

import java.time.LocalDateTime;

public interface UserRepository {

    long registerUser(LocalDateTime localDateTime);

}
