package shizuka.domain.upload.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-09-14 15:00
 */
@AllArgsConstructor
public enum UploadDateTypeEnum {
    OPT(1, "门诊"),
    IPT(2, "住院"),
    OPT_IPT(3, "门诊和住院");

    @Getter
    private Integer type;

    @Getter
    private String msg;
}
