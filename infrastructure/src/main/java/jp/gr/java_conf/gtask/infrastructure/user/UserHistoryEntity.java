package jp.gr.java_conf.gtask.infrastructure.user;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserHistoryEntity {

    private long id;
    private long user_id;
    private long amount;
    private String type;
    private long balance;
    private Date update_date;

}