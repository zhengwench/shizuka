package shizuka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-27 14:29
 */
@SpringBootApplication
@ImportResource(locations = {"applicationContext.xml"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
