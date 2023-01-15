package jp.gr.java_conf.gtask.presentation.user.transfer.request.factory;

import jp.gr.java_conf.gtask.application.user.dto.TransferArgsDto;
import jp.gr.java_conf.gtask.domain.datetime.RequestDateTime;
import jp.gr.java_conf.gtask.presentation.user.transfer.request.TransferRequest;
import org.springframework.stereotype.Component;

@Component
public class TransferArgsDtoFactory {

    public TransferArgsDto create(
            long senderUserId,
            TransferRequest transferRequest,
            RequestDateTime requestDateTime) {

        return TransferArgsDto.of(
                senderUserId,
                transferRequest.getRecipientUserId(),
                transferRequest.getBalance(),
                requestDateTime);
    }
}
