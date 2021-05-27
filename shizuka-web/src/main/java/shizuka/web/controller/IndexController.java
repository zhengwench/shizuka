package shizuka.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shizuka.web.response.ResponseResult;

/**
 * @author muzhi
 * @create 2021/5/27
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/index")
    public ResponseResult index(){
        return ResponseResult.ok();
    }
}
