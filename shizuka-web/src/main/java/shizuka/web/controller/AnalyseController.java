package shizuka.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-24 14:10
 */
@RestController
public class AnalyseController extends BaseController {

    @RequestMapping(value = "/analyse/index")
    String index(){
        return "jidnex";
    }
}
