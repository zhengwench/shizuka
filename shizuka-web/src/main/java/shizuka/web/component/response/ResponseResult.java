package shizuka.web.component.response;

import lombok.Data;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-28 09:57
 */
@Data
public class ResponseResult<T> {
    private Boolean success;

    private Integer code;

    private String msg;

    private T result;

    public ResponseResult() {
    }

    public static <T> ResponseResult<T> ok(T data) {
        ResponseResult<T> result = new ResponseResult();
        //result.setSuccess(true);
        result.setResult(data);
        return result;
    }

    public static <T> ResponseResult<T> fail(int code, String msg) {
        ResponseResult<T> result = new ResponseResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> ResponseResult<T> fail(String msg) {
        ResponseResult<T> result = new ResponseResult();
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }
}
