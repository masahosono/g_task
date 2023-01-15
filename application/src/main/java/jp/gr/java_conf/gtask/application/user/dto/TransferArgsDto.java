package jp.gr.java_conf.gtask.application.user.dto;

import jp.gr.java_conf.gtask.domain.datetime.RequestDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class TransferArgsDto {

    private final long senderUserId;

    private final long recipientUserId;

    private final long balance;

    private final RequestDateTime requestDateTime;
}
