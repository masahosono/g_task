package jp.gr.java_conf.gtask.infrastructure.user;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBalanceEntity {

    private long id;
    private long user_id;
    private long balance;
    private Date update_date;

}