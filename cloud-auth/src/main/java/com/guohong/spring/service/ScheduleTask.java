package com.guohong.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author guohong
 * 测试定时任务
 */
public class ScheduleTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    /**
     * 该方法为定时方法  基本是一秒执行一次 如果不手动停止 程序就会一直执行下去
     * 并且执行这个任务的线程一直是scheduling-1 这就意味着，这个定时任务启动是由单独的一个线程去执行的。
     *
     *如果执行时间比任务周期长 那么就按照
     */
//    @Scheduled(cron = "*/1 * * * * ?")
//    public void execute() {
//        logger.info("print word.");
//        logger.info(String.valueOf(System.currentTimeMillis()));
//        try {
//            Thread.sleep(6000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}
