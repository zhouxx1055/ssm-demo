package com.zxx.demo.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/3  19:04
 */
@Service
@Slf4j
public class ScheduleJob {



    /**
     * 定时任务执行
     * XML方式
     */
    public void runJob(){
        log.info("XML定时任务执行：{} {}",Thread.currentThread().getName(), System.currentTimeMillis());
    }

    /**
     * 定时任务执行
     * 注解方式
     * 每5秒执行一次
     */
    @Scheduled(cron = "0/5 * * * * *")
    public void runJob2(){
        log.info("注解定时任务执行：{} {}", Thread.currentThread().getName(),System.currentTimeMillis());
    }
}
