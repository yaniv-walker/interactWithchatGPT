package com.yan.livestream.api.service;

import com.yan.livestream.api.domain.CommonResultVO;
import com.yan.livestream.api.domain.TimeSyncCommentVO;

import java.util.List;

/**
 * live stream API.
 *
 * @author yanjiaqi
 * @version 1.0.0
 * @date 2023/6/4 0004
 * @since JDK 1.8.0
 */
public interface ILiveStreamAPI {

    /**
     * get time-sync comments.
     * @param roomId live room id
     * @return time-sync comments
     */
    CommonResultVO getTimeSyncCommentsHistory(String roomId);

    /**
     * Get time-sync comments response.
     * @param roomId roomId
     * @return time-sync comments
     */
    List<TimeSyncCommentVO> getTimeSyncComments(String roomId);
}
