package com.yan.chatgpt.api.client.service;

import com.yan.chatgpt.api.client.domain.vo.ChatGPTRequestVO;
import com.yan.chatgpt.api.client.domain.vo.ChatGPTResponseVO;
import com.yan.chatgpt.api.client.domain.vo.MessageInfoVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class ChatGPTClientTest {

    @Test
    void getChatGPTResponse() {
        final IChatGPTClient chatGPTClient = new ChatGPTClient();
        final MessageInfoVO messageInfoVO = MessageInfoVO.builder()
                .role("user")
                .content("我想知道怎么创业的，你能给出具体的建议以及例子吗？")
                .build();
        final ChatGPTRequestVO requestVO = ChatGPTRequestVO.builder()
                .model("gpt-3.5-turbo")
                .proxyHost("127.0.0.1")
                .proxyPort(7890)
                .messages(Collections.singletonList(messageInfoVO))
                .max_tokens(50)
                .build();
        final ChatGPTResponseVO chatGPTResponse = chatGPTClient.getChatGPTResponse(requestVO);
        Assertions.assertNotNull(chatGPTResponse);
        Assertions.assertNotNull(chatGPTResponse.getChoices());
        Assertions.assertNotNull(chatGPTResponse.getChoices().get(0));
        Assertions.assertNotNull(chatGPTResponse.getChoices().get(0).getMessage());
        Assertions.assertNotNull(chatGPTResponse.getChoices().get(0).getMessage().getContent());
        System.out.println(chatGPTResponse);
    }
}