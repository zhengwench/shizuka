package shizuka.domain.analyse.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-09-04 17:06
 */
@Getter
@ToString
@EqualsAndHashCode
public class AnalyseOptPatientSummary {
    private OptPatientAnalyseExecutor executor;

    private List<AnalyseOptPatientResult> analyseOptPatientResultList;
}
