package com.yan.livestream.api.service;

import com.yan.livestream.api.domain.CommonResultVO;
import com.yan.livestream.api.domain.TimeSyncCommentAdminInfoVO;
import com.yan.livestream.api.domain.TimeSyncCommentVO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class BiliBiliLiveStreamAPITest {

    static ILiveStreamAPI API;

    @BeforeAll
    static void before() {
        API = new BiliBiliLiveStreamAPI();
    }

    @Test
    void getTimeSyncCommentsHistory() {
//        final ILiveStreamAPI api = new BiliBiliLiveStreamAPI();
        final CommonResultVO commonResultVO = API.getTimeSyncCommentsHistory("5050");
        System.out.println(commonResultVO);
        if (commonResultVO.getCode() == 0) {
            // success
            final TimeSyncCommentAdminInfoVO timeSyncComment = commonResultVO.getData();
            final List<TimeSyncCommentVO> adminTimeSyncCommentVOList = timeSyncComment.getAdmin();
            final List<TimeSyncCommentVO> roomTimeSyncCommentVOList = timeSyncComment.getRoom();
            adminTimeSyncCommentVOList.forEach(timeSyncCommentVO ->
                    System.out.printf("%s[%s]: %s%n", timeSyncCommentVO.getNickname(), timeSyncCommentVO.getUid(), timeSyncCommentVO.getText()));
            roomTimeSyncCommentVOList.forEach(timeSyncCommentVO ->
                    System.out.printf("%s[%s]: %s%n", timeSyncCommentVO.getNickname(), timeSyncCommentVO.getUid(), timeSyncCommentVO.getText()));
        }
    }

    @Test
    void getTimeSyncComments() {
        final List<TimeSyncCommentVO> timeSyncComments = API.getTimeSyncComments("5050");
        timeSyncComments.forEach(timeSyncCommentVO ->
                System.out.printf("%s[%s]: %s%n", timeSyncCommentVO.getNickname(), timeSyncCommentVO.getUid(), timeSyncCommentVO.getText()));
    }
}