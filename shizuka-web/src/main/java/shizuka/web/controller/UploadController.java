package shizuka.web.controller;

import shizuka.web.component.response.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-28 09:44
 */
@RestController
public class UploadController extends BaseController {

    @RequestMapping(value = "/upload/create")
    public ResponseResult<Boolean> create(){
        return ResponseResult.ok(true);
    }

    @RequestMapping(value = "/upload/queryPageList")
    public ResponseResult queryPageList(){

        return ResponseResult.ok(null);
    }

    @RequestMapping(value = "/upload/statistics")
    public ResponseResult statistics(){
        return ResponseResult.ok(null);
    }
}
