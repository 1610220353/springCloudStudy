package com.guohong.spring.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @author guohong
 * 定时任务，多线程，方式
 */

//@Configuration
//@EnableScheduling
//@Async
public class ScheduleTaskUtilAsync {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTaskUtilAsync.class);

    @Async
    @Scheduled(fixedDelay = 1000)
    public void first() throws InterruptedException {
        logger.info("第一个定时任务开始 : " + LocalDateTime.now().toLocalTime());

        Thread.sleep(1000 * 10);
    }

    @Async
    @Scheduled(fixedDelay = 2000)
    public void second() {
        logger.info("第二个定时任务开始 : " + LocalDateTime.now().toLocalTime());
    }
}
