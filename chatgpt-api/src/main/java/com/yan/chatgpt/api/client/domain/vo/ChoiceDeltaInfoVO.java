package com.yan.chatgpt.api.client.domain.vo;

import lombok.*;

import java.io.Serializable;

/**
 * Delta info in choice, used in stream chat mode.
 * @author yanjiaqi
 * @version 1.0.0
 * @date 2023/6/17 0017
 * @since JDK 1.8.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChoiceDeltaInfoVO implements Serializable {

    private String role;
    private String content;
}
