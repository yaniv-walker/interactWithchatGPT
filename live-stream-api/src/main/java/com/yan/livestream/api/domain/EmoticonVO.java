package com.yan.livestream.api.domain;

import lombok.*;

import java.io.Serializable;

/**
 * emotion icon.
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
public class EmoticonVO implements Serializable {
    private int id;
    private String emoticon_unique;
    private String text;
    private int perm;
    private String url;
    private int in_player_area;
    private int bulge_display;
    private int is_dynamic;
    private int height;
    private int width;
}
