package jp.gr.java_conf.gtask.domain.user;

import java.util.Date;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class UserHistory {

    private final long id;
    private final long user_id;
    private final long amount;
    private final String type; // TODO: 種別はEnumで定義する
    private final long balance;
    private final Date update_date;

}
