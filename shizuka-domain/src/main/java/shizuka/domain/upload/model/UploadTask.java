package shizuka.domain.upload.model;

import shizuka.domain.DomainRegistry;
import shizuka.domain.upload.enums.UploadDateTypeEnum;
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
 * @Date: 2020 2020-07-27 16:21
 */
@Getter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class UploadTask {

    private Long id;

    private String name;

    private Date startTime;

    private Date endTime;

    /**
     * 医院机构
     */
    private List<Long> zoneIdList;

    /**
     * 上报数据类型
     */
    private List<UploadDateTypeEnum> dateTypeList;

    /**
     * 执行明细
     */
    private List<UploadExecute> uploadExecuteList;

    public UploadTask(){
    }

//    public UploadTask(String name, Date startTime, Date endTime, List<Long> zoneIdList, List<String> dateTypeList){
//        this.name = name;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.zoneIdList = zoneIdList;
//        this.dateTypeList = dateTypeList;
//        uploadExecuteList = new ArrayList<>();
//    }

    /**
     * 创建上报任务
     * @return
     */
    public void create(String name, Date startTime, Date endTime, List<Long> zoneIdList, List<String> dateTypeList){
        //TODO 上报任务创建逻辑
        DomainRegistry.uploadRepository.saveUploadTask(this);
    }

    /**
     * 上报执行
     */
    public void uploadExecute(){
        if (!CollectionUtils.isEmpty(uploadExecuteList)){
            for (UploadExecute e:uploadExecuteList) {
                e.execute();
            }
        }
    }
}
