package com.yan.livestream.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yan.livestream.api.domain.CommonResultVO;
import com.yan.livestream.api.domain.TimeSyncCommentAdminInfoVO;
import com.yan.livestream.api.domain.TimeSyncCommentVO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * live stream API.
 *
 * @author yanjiaqi
 * @version 1.0.0
 * @date 2023/6/4 0004
 * @since JDK 1.8.0
 */
public class BiliBiliLiveStreamAPI implements ILiveStreamAPI {

    private static final Logger LOG = LoggerFactory.getLogger(BiliBiliLiveStreamAPI.class);

    private static final String GET_TIME_SYNC_COMMENTS_API = "https://api.live.bilibili.com/xlive/web-room/v1/dM/gethistory";

    /**
     * get time-sync comments.
     *
     * @param roomId live room id
     * @return time-sync comments
     */
    @Override
    public CommonResultVO getTimeSyncCommentsHistory(final String roomId) {
        final OkHttpClient client = new OkHttpClient.Builder().build();
        final String apiUrl = GET_TIME_SYNC_COMMENTS_API + "?roomid=" + roomId;
        final Request request = new Request.Builder()
                .url(apiUrl)
                .get()
                .addHeader("Content-Type", "application/json")
                .build();
        try(final Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                final String responseJson = response.body().string();
                System.out.println("Response body: " + responseJson);
                return extractTimeSyncCommentsResponse(responseJson);
            } else {
                // request failed
                throw new IllegalStateException("Request error: " + response.code() + " - " +
                        (response.body() != null ? response.body().string() : null));
            }
        } catch (IOException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("Request BiliBili live stream API failed or convert response failed", e);
            }
            return new CommonResultVO();
        }
    }

    /**
     * Get time-sync comments response.
     *
     * @param roomId roomId
     * @return time-sync comments
     */
    @Override
    public List<TimeSyncCommentVO> getTimeSyncComments(String roomId) {
        final List<TimeSyncCommentVO> comments = new ArrayList<>();

        final CommonResultVO commonResultVO = getTimeSyncCommentsHistory(roomId);
        if (commonResultVO != null && commonResultVO.getCode() == 0) {
            final TimeSyncCommentAdminInfoVO timeSyncCommentAdminInfoVO = commonResultVO.getData();
            if (timeSyncCommentAdminInfoVO != null) {
                comments.addAll(timeSyncCommentAdminInfoVO.getAdmin());
                comments.addAll(timeSyncCommentAdminInfoVO.getRoom());
            }
        }
        return comments;
    }

    /**
     * convert BiliBili time-sync comments response info.
     * @param responseBody response info
     * @return String
     * @throws IOException io exception
     */
    private static CommonResultVO extractTimeSyncCommentsResponse(final String responseBody) throws IOException {
        // Implement the JSON parsing logic to extract the generated response
        // Return the generated response from the JSON data
        return CommonResultVO.readValueFromJSON(responseBody);
    }
}
