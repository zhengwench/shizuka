package shizuka.domain.analyse.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-09-04 16:55
 */
@AllArgsConstructor
public enum AnalyseTypeEnum {
    //
    OPT_RECIPE(1, "门诊处方"),
    OPT_PATIENT(2, "门诊患者"),
    IPT_ORDER(3, "住院医嘱"),
    IPT_PATIENT(4, "住院患者");

    @Getter
    private Integer type;

    @Getter
    private String msg;
}
