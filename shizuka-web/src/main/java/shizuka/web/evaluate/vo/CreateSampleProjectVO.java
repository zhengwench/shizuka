package shizuka.web.evaluate.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-28 09:54
 */
@Data
public class CreateSampleProjectVO {
    private Long id;

    private String projectName;

    private Date startTime;

    private Date endTime;

    private Integer type;
}
