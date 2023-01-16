package jp.gr.java_conf.gtask.infrastructure.user;

import java.time.LocalDateTime;
import java.util.List;
import jp.gr.java_conf.gtask.domain.datetime.RequestDateTime;
import jp.gr.java_conf.gtask.domain.user.UserHistoryList;
import jp.gr.java_conf.gtask.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private final UserHistoryListFactory userHistoryListFactory;

    @Transactional
    public long registerUser(
            LocalDateTime localDateTime) {

        String insertUserQuery = "INSERT INTO user(create_date) VALUES(?)";
        String insertUserBalanceQuery = "INSERT INTO user_balance(user_id, balance, update_date) VALUES(?, ?, ?)";
        String insertUserHistoryQuery =
                "INSERT INTO user_history(user_id, amount, type, balance, update_date) VALUES(?, ?, ?, ?, ?)";

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

    @Transactional
    public long getBalance(
            long userId) {
        String getBalanceQuery = "SELECT * FROM user_balance WHERE user_id = ?";

        try {
            UserBalanceEntity userBalanceEntity =
                    jdbcTemplate.queryForObject(
                            getBalanceQuery,
                            new BeanPropertyRowMapper<>(UserBalanceEntity.class), userId);

            return userBalanceEntity.getBalance();
        } catch (RuntimeException exception) {
            // TODO: 参照結果が0件の場合の例外をハンドリング
            throw exception;
        }
    }

    @Transactional
    public long addBalance(
            long userId,
            long addBalance,
            LocalDateTime localDateTime) {

        String getBalanceQuery = "SELECT * FROM user_balance WHERE user_id = ?";

        String updateUserBalanceQuery = "UPDATE user_balance " +
                "SET balance = ?, update_date = ?" +
                "WHERE user_id = ?";

        String updateUserHistoryQuery =
                "INSERT INTO user_history(user_id, amount, type, balance, update_date) VALUES(?, ?, ?, ?, ?)";

        try {
            UserBalanceEntity userBalanceEntity =
                    jdbcTemplate.queryForObject(
                            getBalanceQuery,
                            new BeanPropertyRowMapper<>(UserBalanceEntity.class), userId);

            long totalBalance = addBalance + userBalanceEntity.getBalance();

            jdbcTemplate.update(
                    updateUserBalanceQuery, totalBalance, localDateTime, userId);
            jdbcTemplate.update(
                    updateUserHistoryQuery, userId, addBalance, "in", totalBalance, localDateTime);

            return totalBalance;
        } catch (RuntimeException exception) {
            throw exception;
        }
    }

    @Transactional
    public long payment(
            long userId,
            long useBalance,
            LocalDateTime localDateTime) {

        String getBalanceQuery = "SELECT * FROM user_balance WHERE user_id = ?";

        String updateUserBalanceQuery = "UPDATE user_balance " +
                "SET balance = ?, update_date = ?" +
                "WHERE user_id = ?";

        String updateUserHistoryQuery =
                "INSERT INTO user_history(user_id, amount, type, balance, update_date) VALUES(?, ?, ?, ?, ?)";

        try {
            UserBalanceEntity userBalanceEntity =
                    jdbcTemplate.queryForObject(
                            getBalanceQuery,
                            new BeanPropertyRowMapper<>(UserBalanceEntity.class), userId);

            long totalBalance = userBalanceEntity.getBalance() - useBalance;

            if (totalBalance < 0) {
                // TODO: 残高を上回った場合例外スロー
            }

            jdbcTemplate.update(
                    updateUserBalanceQuery, totalBalance, localDateTime, userId);
            jdbcTemplate.update(
                    updateUserHistoryQuery, userId, useBalance, "out", totalBalance, localDateTime);

            return totalBalance;
        } catch (RuntimeException exception) {
            throw exception;
        }
    }

    @Transactional
    public long transfer(
            long senderUserId,
            long recipientUserId,
            long useBalance,
            LocalDateTime localDateTime) {

        String getBalanceQuery = "SELECT * FROM user_balance WHERE user_id = ?";

        String updateUserBalanceQuery = "UPDATE user_balance " +
                "SET balance = ?, update_date = ?" +
                "WHERE user_id = ?";

        String updateUserHistoryQuery =
                "INSERT INTO user_history(user_id, amount, type, balance, update_date) VALUES(?, ?, ?, ?, ?)";

        try {
            UserBalanceEntity senderUserBalanceEntity =
                    jdbcTemplate.queryForObject(
                            getBalanceQuery,
                            new BeanPropertyRowMapper<>(UserBalanceEntity.class), senderUserId);
            UserBalanceEntity recipientUserBalanceEntity =
                    jdbcTemplate.queryForObject(
                            getBalanceQuery,
                            new BeanPropertyRowMapper<>(UserBalanceEntity.class), recipientUserId);

            long senderTotalBalance = senderUserBalanceEntity.getBalance() - useBalance;

            long recipientTotalBalance = recipientUserBalanceEntity.getBalance() + useBalance;

            if (senderTotalBalance < 0) {
                // TODO: 残高を上回った場合例外スロー
            }

            // 送金者
            jdbcTemplate.update(
                    updateUserBalanceQuery, senderTotalBalance, localDateTime, senderUserId);
            jdbcTemplate.update(
                    updateUserHistoryQuery,
                    senderUserId,
                    useBalance, "out",
                    senderTotalBalance,
                    localDateTime);

            // 受取
            jdbcTemplate.update(
                    updateUserBalanceQuery, recipientTotalBalance, localDateTime, recipientUserId);
            jdbcTemplate.update(
                    updateUserHistoryQuery,
                    recipientUserId,
                    useBalance, "in",
                    recipientTotalBalance,
                    localDateTime);

            return senderTotalBalance;
        } catch (RuntimeException exception) {
            throw exception;
        }
    }

    @Transactional
    public UserHistoryList getHistory(
            long userId) {
        String getHistoryQuery = "SELECT * FROM user_history WHERE user_id = ?";

        try {
            List<UserHistoryEntity> userHistoryEntity =
                    jdbcTemplate.query(
                            getHistoryQuery,
                            new BeanPropertyRowMapper<>(UserHistoryEntity.class), userId);

            return userHistoryListFactory.from(userHistoryEntity);
        } catch (RuntimeException exception) {
            throw exception;
        }
    }

}
