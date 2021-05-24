package shizuka.web.component.response;

import lombok.Data;

import java.util.List;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-28 10:00
 */
@Data
public class PageResponseResult<T> {
    private Boolean success;

    private Integer code;

    private String msg;

    private Integer total;

    private Integer limit;

    private List<T> rows;

    public PageResponseResult() {
    }

    public static <T> PageResponseResult<T> ok(List<T> data) {
        PageResponseResult<T> result = new PageResponseResult();
        result.setSuccess(true);
        result.setRows(data);
        return result;
    }

    public static <T> PageResponseResult<T> fail(int code, String msg) {
        PageResponseResult<T> result = new PageResponseResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
