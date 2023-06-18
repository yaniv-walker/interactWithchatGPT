package com.yan.chat.domain.context;

import com.yan.chatgpt.api.client.service.IChatGPTClient;
import com.yan.livestream.api.domain.TimeSyncCommentVO;
import lombok.*;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * .
 *
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
public class ChatContext {

    /**
     * ChatGPT.
     */
    private IChatGPTClient chatGPTClient;

    /**
     * Live stream comments info.
     */
    private List<TimeSyncCommentVO> timeSyncComments;

    /**
     * using stream to chat with ChatGPT.
     */
    private Boolean stream;

    /**
     * check if have time-sync comment.
     * @return true: have comments, false: have not comments
     */
    public Boolean checkIfHaveComment() {
        return CollectionUtils.isNotEmpty(timeSyncComments);
    }
}
