package shizuka.domain.analyse.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-09-10 16:44
 */
@AllArgsConstructor
public enum AnalyseExecutorStatusEnum {
    UNEXECUTE(1, "未执行"),
    EXECUTEING(2, "执行中"),
    EXECUTEED(3, "已执行");

    @Getter
    private Integer status;

    @Getter
    private String msg;
}
