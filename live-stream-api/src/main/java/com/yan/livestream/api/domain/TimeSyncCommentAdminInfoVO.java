package com.yan.livestream.api.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * time-sync comment info.
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
public class TimeSyncCommentAdminInfoVO implements Serializable {

    private List<TimeSyncCommentVO> admin;
    private List<TimeSyncCommentVO> room;
}
