package com.yan.livestream.api.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * .
 *
 * @author yanjiaqi
 * @version 1.0.0
 * @date 2023/6/6 0006
 * @since JDK 1.8.0
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TimeSyncCommentVO implements Serializable {
    /**
     * The text of the danmaku.
     */
    private String text;

    /**
     * The type of the danmaku.
     */
    private Integer dm_type;

    /**
     * The user ID of the danmaku sender.
     */
    private Long uid;

    /**
     * The nickname of the danmaku sender.
     */
    private String nickname;

    /**
     * The color of the danmaku sender's username.
     */
    private String uname_color;

    /**
     * The timestamp when the danmaku was sent.
     */
    private String timeline;

    /**
     * Whether the danmaku sender is an administrator.
     */
    private int isadmin;

    /**
     * Whether the danmaku sender is a VIP member.
     */
    private int vip;

    /**
     * Whether the danmaku sender is a super VIP member.
     */
    private int svip;

    /**
     * The medal information of the danmaku sender.
     */
    private List<Object> medal;

    /**
     * The title of the danmaku sender.
     */
    private String[] title;

    /**
     * The user level information of the danmaku sender.
     */
    private Object[] user_level;

    /**
     * The rank of the danmaku sender.
     */
    private int rank;

    /**
     * The team ID of the danmaku sender.
     */
    private int teamid;

    /**
     * The random number of the danmaku.
     */
    private String rnd;

    /**
     * The user title of the danmaku sender.
     */
    private String user_title;

    /**
     * The guard level of the danmaku sender.
     */
    private int guard_level;

    /**
     * The bubble type of the danmaku.
     */
    private int bubble;

    /**
     * The color of the bubble of the danmaku.
     */
    private String bubble_color;

    /**
     * The live platform level of the danmaku.
     */
    private int lpl;

    /**
     * The personal space URL of the danmaku sender.
     */
    private String yeah_space_url;

    /**
     * The jump URL of the danmaku.
     */
    private String jump_to_url;

    /**
     * The check information of the danmaku.
     */
    private CheckInfoVO check_info;

    /**
     * The voice danmaku information of the danmaku.
     */
    private VoiceDmInfoVO voice_dm_info;

    /**
     * The emoticon information of the danmaku.
     */
    private EmoticonVO emoticon;

    /**
     * The emoticon information of the danmaku.
     */
    private Object emots;

    /**
     * The ID of the danmaku in string format.
     */
    private String id_str;

    /**
     * wealth level.
     */
    private Integer wealth_level;

    /**
     * bubble id.
     */
    private String bubble_id_v2;
}
