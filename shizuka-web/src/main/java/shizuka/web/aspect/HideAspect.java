package shizuka.web.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author muzhi
 * @create 2021/5/27
 */
@Component
@Aspect
public class HideAspect {
    // 配置切点
    @Before("@annotation(hide)")
    @Order(0)
    public void before(Hide hide){
        //TODO
    }
}
