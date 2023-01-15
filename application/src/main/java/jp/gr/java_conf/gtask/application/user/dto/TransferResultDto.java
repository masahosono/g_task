package jp.gr.java_conf.gtask.application.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class TransferResultDto {

    private final long userId;

    private final long balance;
}
