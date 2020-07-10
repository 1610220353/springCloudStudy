package com.guohong.spring.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;

/**
 * @author guohong
 * 1.主要用于标记配置类，兼备Component的效果。
 * EnableScheduling 注解为 开启定时任务
 * 单线程
 */

//@Configuration
//@EnableScheduling
public class ScheduleTaskUtil  implements SchedulingConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTaskUtil.class);

    /**
     * 该方法为定时方法  基本是一秒执行一次 如果不手动停止 程序就会一直执行下去
     * 并且执行这个任务的线程一直是scheduling-1 这就意味着，这个定时任务启动是由单独的一个线程去执行的。
     *
     *如果执行时间比任务周期长 那么就按照
     *
     * Cron表达式
     *
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        scheduledTaskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> {
                    logger.info("执行动态定时任务: " + LocalDateTime.now().toLocalTime());
                },
                //2.设置执行周期(Trigger)
                triggerContext -> {
//                    //2.1 从数据库获取执行周期
//                    String cron = cronMapper.getCron();
//                    //2.2 合法性校验.
//                    if (StringUtils.isEmpty(cron)) {
//                        // Omitted Code ..
//                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger("*/10000 * * * * ?").nextExecutionTime(triggerContext);
                }
        );

    }
}
