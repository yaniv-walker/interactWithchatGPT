package com.yan.chatgpt.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * chatGPT请求体.
 *
 * @author yanjiaqi
 * @version 1.0.0
 * @date 2023/6/2 0002
 * @since JDK 1.8.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatGPTRequestVO implements Serializable {

    /**
     * ID of the model to use.
     * You can use the List models API to see all of your available models,
     * or see our Model overview for descriptions of them..
     */
    private String model;

    /**
     * The maximum number of tokens to generate in the completion.
     */
    private Integer max_tokens;

    /**
     * message.
     */
    private List<MessageInfoVO> messages;

    /**
     * request proxy host.
     */
    @JsonIgnore
    private String proxyHost;

    /**
     * request proxy port.
     */
    @JsonIgnore
    private Integer proxyPort;

    /**
     * converter this to JSON.
     * @return JSON String
     * @throws JsonProcessingException json exception
     */
    public String toJSON() throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
