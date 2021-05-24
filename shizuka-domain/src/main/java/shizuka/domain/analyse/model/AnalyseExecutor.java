package shizuka.domain.analyse.model;

import shizuka.domain.DomainRegistry;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-24 13:38
 */
@Getter
@ToString
public abstract class AnalyseExecutor {

    protected Long id;

    protected Long analyseDetailId;

    protected Long zoneId;

    protected Date keyDate;

    protected Integer analyseType;

    protected String bizId;

    protected String bizInfo;

    protected Integer status;

    protected String extendInfo;

    protected Date createTime;

    protected Date updateTime;

    public AnalyseExecutor(){

    }

    public AnalyseExecutor(Long id,Long analyseDetailId,Long zoneId,Date keyDate,Integer analyseType,
                                     String bizId,String bizInfo,Integer status,String extendInfo,Date createTime,Date updateTime){
        this.id = id;
        this.analyseDetailId = analyseDetailId;
        this.zoneId = zoneId;
        this.keyDate = keyDate;
        this.analyseType = analyseType;
        this.bizId = bizId;
        this.bizInfo = bizInfo;
        this.status = status;
        this.extendInfo = extendInfo;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public void create(Long analyseDetailId,Long zoneId,Date keyDate,Integer analyseType,
                       String bizId,String bizInfo){
        this.analyseDetailId = analyseDetailId;
        this.zoneId = zoneId;
        this.keyDate = keyDate;
        this.analyseType = analyseType;
        this.bizId = bizId;
        this.bizInfo = bizInfo;
        this.status = 1;
        this.extendInfo = extendInfo;
        DomainRegistry.analyseRepository.saveAnalyseExecutor(this);
    }

    public void execute(){
        //TODO 执行器执行逻辑
        DomainRegistry.pushService.pushRabbitMq("","","");
    }

    public void callback(){
        //TODO 执行器回调处理逻辑
    }
}
