package com.yan.livestream.api.domain;

import lombok.*;

import java.io.Serializable;

/**
 * check info.
 *
 * @author yanjiaqi
 * @version 1.0.0
 * @date 2023/6/6 0006
 * @since JDK 1.8.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CheckInfoVO implements Serializable {

    private long ts;
    private String ct;
}
