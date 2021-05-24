package shizuka.domain.analyse.model;

import shizuka.domain.DomainRegistry;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-09-04 16:25
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class OptPatientAnalyseExecutor extends AnalyseExecutor {
    public OptPatientAnalyseExecutor(){
    }

    @Builder
    public OptPatientAnalyseExecutor(Long id,Long analyseDetailId,Long zoneId,Date keyDate,Integer analyseType,
                                     String bizId,String bizInfo,Integer status,String extendInfo,Date createTime,Date updateTime){
        super(id,analyseDetailId,zoneId,keyDate,analyseType,bizId,bizInfo,status,extendInfo,createTime,updateTime);
    }

    @Override
    public void create(Long analyseDetailId,Long zoneId,Date keyDate,Integer analyseType,
                       String bizId,String bizInfo){
    }

    @Override
    public void execute(){
        //TODO 执行器执行逻辑
        DomainRegistry.pushService.pushRabbitMq("","","");
    }

    @Override
    public void callback() {
        //TODO 分析执行回调处理
    }
}
