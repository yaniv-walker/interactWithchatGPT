package com.yan.chatgpt.api.client.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yan.chatgpt.api.client.domain.ChatGPTRequestVO;
import com.yan.chatgpt.api.client.domain.ChatGPTResponseVO;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

/**
 * ChatGPT API调用端.
 *
 * @author yanjiaqi
 * @version 1.0.0
 * @date 2023/6/1 0001
 * @since JDK 1.8.0
 */
public class ChatGPTClient implements IChatGPTClient {

    private static final Logger LOG = LoggerFactory.getLogger(ChatGPTClient.class);

//    private static final String OPENAI_API_URL = "https://api.openai.com/v1/engines/davinci-codex/completions";
    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    // my key


    private static final String OPENAI_API_KEY = "";

    /**
     * get response info from ChatGPT.
     * @param requestVO user prompt inputted for ChatGPT
     * @return ChatGPT response
     */
    @Override
    public ChatGPTResponseVO getChatGPTResponse(final ChatGPTRequestVO requestVO) {
        if (Objects.isNull(requestVO)) {
            return new ChatGPTResponseVO();
        }
        final OkHttpClient client = getOkHttpClient(requestVO.getProxyHost(), requestVO.getProxyPort());
        final Request request = getRequest(requestVO);
        return requestChatGPT(client, request);
    }

    /**
     * request ChatGPT and convert its response to VO.
     * @param client the http client
     * @param request the ChatGPT API need
     * @return ChatGPTResponseVO
     */
    private ChatGPTResponseVO requestChatGPT(final OkHttpClient client, final Request request) {
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                final String responseBody = response.body().string();
                // Parse the JSON response and extract the generated response from the model
                // You can use a JSON library like Gson or Jackson for parsing the response
                // Extract the generated response from the JSON and return it
                return extractGeneratedResponse(responseBody);
            } else {
                throw new IllegalStateException("Error: " + response.code() + " - " +
                        (response.body() != null ? response.body().string() : null));
            }
        } catch (Exception e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("Request ChatGPT failed or convert response failed", e);
            }
            return new ChatGPTResponseVO();
        }
    }

    /**
     * build request info.
     * @param requestVO the param is needed in request ChatGPT
     * @return request info
     */
    @NotNull
    private Request getRequest(final ChatGPTRequestVO requestVO) {
        try {
            final MediaType mediaType = MediaType.parse("application/json");
            final String json = requestVO.toJSON();
            if (LOG.isInfoEnabled()) {
                LOG.info("Request JSON: {}", json);
            }
            final RequestBody requestBody = RequestBody.create(json, mediaType);
            return new Request.Builder()
                    .url(OPENAI_API_URL)
                    .post(requestBody)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
                    .build();

        } catch (JsonProcessingException e) {
            throw new RuntimeException("converting ChatGPTRequestVO to JSON failed", e);
        }
    }

    /**
     * get http client.
     * @return OkHttpClient
     */
    @NotNull
    private OkHttpClient getOkHttpClient(final String proxyHost, final Integer proxyPort) {
        final OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        // Configure proxy server if needed
        if (StringUtils.isNotBlank(proxyHost)) {
            final Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
            clientBuilder.proxy(proxy);
        }

        return clientBuilder.build();
    }

    /**
     * convert ChatGPT response info.
     * @param responseBody response info
     * @return ChatGPTResponseVO
     * @throws IOException io exception
     */
    private static ChatGPTResponseVO extractGeneratedResponse(String responseBody) throws IOException {
        // Implement the JSON parsing logic to extract the generated response
        // Return the generated response from the JSON data
        return ChatGPTResponseVO.readValueFromJSON(responseBody);
    }

}
