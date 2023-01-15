package jp.gr.java_conf.gtask.infrastructure.user;

import java.util.List;
import java.util.stream.Collectors;
import jp.gr.java_conf.gtask.domain.user.UserHistory;
import jp.gr.java_conf.gtask.domain.user.UserHistoryList;
import org.springframework.stereotype.Component;

@Component
public class UserHistoryListFactory {

    public UserHistoryList from(List<UserHistoryEntity> userHistoryEntities) {
        return UserHistoryList.of(userHistoryEntities.stream()
                .map(userHistoryEntity ->
                        UserHistory.of(
                                userHistoryEntity.getId(),
                                userHistoryEntity.getUser_id(),
                                userHistoryEntity.getAmount(),
                                userHistoryEntity.getType(),
                                userHistoryEntity.getBalance(),
                                userHistoryEntity.getUpdate_date()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf)));
    }
}
