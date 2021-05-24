package shizuka.web.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-28 10:08
 */
@Slf4j
public abstract class BaseController {

    public Integer getCurrentUserId(HttpServletRequest request){
        return 0;
    }
}
