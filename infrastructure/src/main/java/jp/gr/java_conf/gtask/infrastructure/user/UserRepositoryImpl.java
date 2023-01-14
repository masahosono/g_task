package jp.gr.java_conf.gtask.infrastructure.user;

import java.time.LocalDateTime;
import jp.gr.java_conf.gtask.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public long registerUser(LocalDateTime localDateTime) {
        String insertUserQuery = "INSERT INTO user(create_date) VALUES(?)";
        String insertUserBalanceQuery = "INSERT INTO user_balance(user_id, balance, update_date) VALUES(?, ?, ?)";
        String insertUserHistoryQuery = "INSERT INTO user_history(user_id, amount, type, balance, update_date) VALUES(?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(insertUserQuery, localDateTime);

            long registerdUserId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);

            jdbcTemplate.update(
                    insertUserBalanceQuery, registerdUserId, 0, localDateTime);
            jdbcTemplate.update(
                    insertUserHistoryQuery, registerdUserId, 0, "in", 0, localDateTime);

            return registerdUserId;
        } catch (RuntimeException exception) {
            throw exception;
        }
    }

}
