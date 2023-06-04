package com.yan.chatgpt.api.client.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * ChatGPT响应.
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
public class ChatGPTResponseVO implements Serializable {

    private String id;
    private String object;
    private Integer created;
    private String model;
    private List<ChoiceInfoVO> choices;
    private UsageInfoVO usage;

    /**
     * converter json to ChatGPTResponse.
     * @param json the ChatGPTResponse json string.
     * @return ChatGPTResponse object
     */
    public static ChatGPTResponseVO readValueFromJSON(final String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ChatGPTResponseVO.class);
    }
}
