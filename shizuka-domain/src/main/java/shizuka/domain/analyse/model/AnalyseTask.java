package shizuka.domain.analyse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-24 13:37
 */
@Getter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class AnalyseTask {
    private Long id;

    private String name;

    private Date startTime;

    private Date endTime;

    private Integer type;

    private Integer autoFlag;

    private Integer status;

    private Long operateUserId;

    private String operateUserName;

    private Date createTime;

    private Date updateTime;

    private List<AnalyseTaskDetail> analyseTaskDetailList;

    public AnalyseTask(){}

    public void create(){
        //TODO 创建逻辑
    }

    /**
     * 分析执行
     */
    public void analyseExecute(){
        if (!CollectionUtils.isEmpty(analyseTaskDetailList)){
            for (AnalyseTaskDetail analyseTaskDetail:analyseTaskDetailList) {
                analyseTaskDetail.splitAnalyseExecutor();
            }
        }
    }
}
