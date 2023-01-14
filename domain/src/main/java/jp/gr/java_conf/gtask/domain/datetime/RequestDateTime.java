package jp.gr.java_conf.gtask.domain.datetime;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RequestDateTime {

    private final LocalDateTime value;

    public static RequestDateTime nowWith(Clock clock) {
        return new RequestDateTime(LocalDateTime.now(clock));
    }

    public String format() {
        return value.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

}
