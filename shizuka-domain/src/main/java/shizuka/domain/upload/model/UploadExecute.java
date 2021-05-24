package shizuka.domain.upload.model;

import shizuka.domain.DomainRegistry;
import shizuka.domain.upload.listener.UploadExecuteListener;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-27 16:29
 */
@Getter
@ToString
@EqualsAndHashCode
public class UploadExecute {
    private Long id;

    private Long taskId;

    private Date keyDate;

    private String dateType;

    private Integer status;

    private Date createTime;

    private Date finishTime;

    private List<UploadExecuteListener> uploadExecuteListenerList = new ArrayList<>();

    public void registryUploadExecuteListener(UploadExecuteListener listener){
        uploadExecuteListenerList.add(listener);
    }

    /**
     * 执行上报
     */
    public void execute(){
        //TODO

        DomainRegistry.pushService.pushRabbitMq("","","");
    }

    private void pushUploadExecuteSuccessEvent(){
        for (UploadExecuteListener listener:uploadExecuteListenerList) {
            listener.execute(this);
        }
    }

    public void callback(){
        //TODO 上报执行回调处理

        pushUploadExecuteSuccessEvent();
    }
}
