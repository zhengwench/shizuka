package shizuka.infrastructure.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-28 16:09
 */
@Configuration
public class ThreadPoolTaskExecutorConfig {
    @Bean
    public ThreadPoolExecutor threadPoolTaskExecutor(){

        return new ThreadPoolExecutor(10, 100, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
