package com.yan.chatgpt.api.client.service;

import com.yan.chatgpt.api.client.domain.vo.ChatGPTRequestVO;
import com.yan.chatgpt.api.client.domain.vo.ChatGPTResponseVO;

/**
 * ChatGPT API调用端.
 *
 * @author yanjiaqi
 * @version 1.0.0
 * @date 2023/6/3 0003
 * @since JDK 1.8.0
 */
public interface IChatGPTClient {
    /**
     * get response info from ChatGPT.
     * @param requestVO user prompt inputted for ChatGPT
     * @return ChatGPT response
     */
    ChatGPTResponseVO getChatGPTResponse(ChatGPTRequestVO requestVO);
}
