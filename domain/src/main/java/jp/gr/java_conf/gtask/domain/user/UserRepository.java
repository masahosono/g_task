package jp.gr.java_conf.gtask.domain.user;

import java.time.LocalDateTime;
import jp.gr.java_conf.gtask.domain.datetime.RequestDateTime;

public interface UserRepository {

    long registerUser(LocalDateTime localDateTime);

    long getBalance(long userId);

    long addBalance(long userId, long balance, LocalDateTime localDateTime);


}
