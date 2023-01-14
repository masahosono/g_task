package jp.gr.java_conf.simpleblogapi.infrastructure.user;

import jp.gr.java_conf.gtask.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public long registerUser() {

        String query = "INSERT INTO user() " +
                "VALUES()";
        try {
            jdbcTemplate.update(
                    query);
            return 1L;
        } catch (RuntimeException exception) {
            throw exception;
        }
    }

}
