package shizuka.web.controller;

import shizuka.web.evaluate.vo.CreateSampleProjectVO;
import shizuka.web.component.response.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-28 09:45
 */
@RestController
public class EvaluateController extends BaseController {

    @RequestMapping(value = "/evaluateProject/create")
    public ResponseResult createSampleProject(@RequestBody CreateSampleProjectVO createSampleProject){
        if (createSampleProject == null){
            return ResponseResult.fail("请求参数为空");
        }
        return ResponseResult.ok("");
    }

    @RequestMapping(value = "/evaluateProject/update")
    public ResponseResult updateSampleProject(@RequestBody CreateSampleProjectVO createSampleProject){
        if (createSampleProject == null){
            return ResponseResult.fail("请求参数为空");
        }
        return ResponseResult.ok("");
    }

    @RequestMapping(value = "/evaluateProject/remove")
    public ResponseResult removeSampleProject(@RequestBody Long id){
        if (id == null){
            return ResponseResult.fail("请求参数为空");
        }
        return ResponseResult.ok("");
    }

    @RequestMapping(value = "/evaluateProject/extract")
    public ResponseResult extract(@RequestBody Long id){
        return ResponseResult.ok(null);
    }
}
