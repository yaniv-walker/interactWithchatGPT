package com.yan.chatgpt.api.client.domain;

import lombok.*;

import java.io.Serializable;

/**
 * .
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
public class MessageInfoVO implements Serializable {

    private String role;
    private String content;
}
