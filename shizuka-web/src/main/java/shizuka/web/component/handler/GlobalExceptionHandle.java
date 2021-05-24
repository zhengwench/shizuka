package shizuka.web.component.handler;

import shizuka.web.component.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-28 10:09
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public <T> ResponseResult<T> handle(HttpServletRequest request, Exception e) {
        log.error("请求网关异常,request={}",request.getParameterMap().toString(),e);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(false);
        responseResult.setCode(500);
        responseResult.setMsg("服务器内部错误");
        return responseResult;
    }
}
