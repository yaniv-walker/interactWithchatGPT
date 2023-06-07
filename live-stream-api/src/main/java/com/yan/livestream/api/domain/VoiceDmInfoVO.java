package com.yan.livestream.api.domain;

import lombok.*;

/**
 * Voice time-sync comments info.
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
public class VoiceDmInfoVO {

    private String voice_url;
    private String file_format;
    private String text;
    private int file_duration;
    private String file_id;
}
