package jp.gr.java_conf.gtask.domain.user;

import java.time.LocalDateTime;

public interface UserRepository {

    long registerUser(LocalDateTime localDateTime);

    long getBalance(long userId);

    long addBalance(long userId, long balance, LocalDateTime localDateTime);

    long payment(long userId, long balance, LocalDateTime localDateTime);

    long transfer(long senderUserId, long recipientUserId, long balance, LocalDateTime localDateTime);

}
