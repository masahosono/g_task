package jp.gr.java_conf.gtask.domain.user;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class UserHistoryList {

    private final List<UserHistory> userHistories;

}
