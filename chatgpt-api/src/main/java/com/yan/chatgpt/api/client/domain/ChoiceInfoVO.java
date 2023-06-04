package com.yan.chatgpt.api.client.domain;

import lombok.*;

import java.io.Serializable;

/**
 * Chat response choice info.
 *
 * @author yanjiaqi
 * @version 1.0.0
 * @date 2023/6/3 0003
 * @since JDK 1.8.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChoiceInfoVO implements Serializable {

    private String text;
    private MessageInfoVO message;
    private Integer index;
    private Integer logprobs;
    private String finish_reason;
}
