package shizuka.domain.analyse.model;

import shizuka.domain.analyse.enums.AnalyseTypeEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-24 13:38
 */
@Getter
@ToString
@EqualsAndHashCode
public class AnalyseTaskDetail {

    private Long id;

    private Long analyseTaskId;

    private Long zoneId;

    private Integer type;

    private Date keyDate;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public void splitAnalyseExecutor(){
        //TODO 构建执行逻辑
        if (AnalyseTypeEnum.OPT_RECIPE.getType().equals(type)){
            OptRecipeAnalyseExecutor optRecipeAnalyseExecutor = new OptRecipeAnalyseExecutor();
            optRecipeAnalyseExecutor.create(null,null,null,null,null,null);
            optRecipeAnalyseExecutor.execute();
        }
        if (AnalyseTypeEnum.OPT_PATIENT.getType().equals(type)){
            OptPatientAnalyseExecutor optPatientAnalyseExecutor = new OptPatientAnalyseExecutor();
            optPatientAnalyseExecutor.create(null,null,null,null,null,null);
            optPatientAnalyseExecutor.execute();
        }
        if (AnalyseTypeEnum.IPT_PATIENT.getType().equals(type)){
            IptPatientAnalyseExecutor iptPatientAnalyseExecutor = new IptPatientAnalyseExecutor();
            iptPatientAnalyseExecutor.create(null,null,null,null,null,null);
            iptPatientAnalyseExecutor.execute();
        }
    }
}
