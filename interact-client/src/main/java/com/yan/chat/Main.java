package com.yan.chat;

import com.yan.chat.domain.context.ChatContext;
import com.yan.chatgpt.api.client.domain.vo.ChatGPTRequestVO;
import com.yan.chatgpt.api.client.domain.vo.ChatGPTResponseVO;
import com.yan.chatgpt.api.client.domain.vo.MessageInfoVO;
import com.yan.chatgpt.api.client.service.ChatGPTClient;
import com.yan.chatgpt.api.client.service.IChatGPTClient;
import com.yan.livestream.api.domain.TimeSyncCommentVO;
import com.yan.livestream.api.service.BiliBiliLiveStreamAPI;
import com.yan.livestream.api.service.ILiveStreamAPI;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        final IChatGPTClient chatGPTClient = new ChatGPTClient();
        final ILiveStreamAPI liveStreamAPI = new BiliBiliLiveStreamAPI();

        // get time-sync comments and use it to generate chat messages
        // 老E
//        final String roomId = "5050";
        // C酱
        final String roomId = "213";
        final List<TimeSyncCommentVO> timeSyncComments = liveStreamAPI.getTimeSyncComments(roomId);

        // set chat context
        final ChatContext chatContext = ChatContext.builder()
                .chatGPTClient(chatGPTClient)
                .timeSyncComments(timeSyncComments)
                .stream(false)
                .build();

        // if comments is not null, to chat with ChatGPT
        interactWithChatGPT(chatContext);
    }

    private static void interactWithChatGPT(final ChatContext chatContext) {
        if (!chatContext.checkIfHaveComment()) {
            return;
        }

        // build request
        final Stream<ChatGPTResponseVO> chatGPTResponseVOStream = chatContext.getTimeSyncComments()
                .stream()
                .map(timeSyncCommentVO -> MessageInfoVO.builder()
                        .role("user")
                        .content(timeSyncCommentVO.getText())
                        .build()).map(messageInfoVO -> ChatGPTRequestVO.builder()
                        .model("gpt-3.5-turbo")
                        .proxyHost("127.0.0.1")
                        .proxyPort(7890)
                        .max_tokens(100)
                        .stream(chatContext.getStream())
                        .messages(Collections.singletonList(messageInfoVO))
                        .build()).map(requestVO -> chatContext.getChatGPTClient()
                        .getChatGPTResponse(requestVO))
                .filter(chatGPTResponseVO -> null != chatGPTResponseVO && CollectionUtils.isNotEmpty(chatGPTResponseVO.getChoices()));


        if (chatContext.getStream()) {
            chatGPTResponseVOStream.map(chatGPTResponseVO -> chatGPTResponseVO.getChoices().get(0))
                    .forEach(choiceInfoVO -> {
                        System.out.println(choiceInfoVO.getDelta().getContent());
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
            });
        } else {
            chatGPTResponseVOStream.map(chatGPTResponseVO -> chatGPTResponseVO.getChoices().get(0).getMessage().getContent())
                    .forEach(content -> {
                System.out.println(content);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}