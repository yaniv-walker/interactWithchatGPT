package com.yan.livestream.api.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.IOException;
import java.io.Serializable;

/**
 * common result.
 *
 * @author yanjiaqi
 * @version 1.0.0
 * @date 2023/6/7 0007
 * @since JDK 1.8.0
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonResultVO implements Serializable {

    private Integer code;
    private TimeSyncCommentAdminInfoVO data;
    private String message;
    private String msg;

    /**
     * read value from json.
     * @param json json string
     * @return CommonResultVO
     * @throws IOException json exception
     */
    public static CommonResultVO readValueFromJSON(final String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, CommonResultVO.class);
    }
}
