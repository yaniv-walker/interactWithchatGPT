package com.yan.chatgpt.api.client.domain.vo;

import lombok.*;

import java.io.Serializable;

/**
 * usage info.
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
public class UsageInfoVO implements Serializable {

    private Integer prompt_tokens;
    private Integer completion_tokens;
    private Integer total_tokens;
}
