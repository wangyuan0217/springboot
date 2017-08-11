package com.trump.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * test 定时任务
 */
@Component
public class SchedulerTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    //    @Scheduled(cron = "*/6 * * * * ?")
    // @Scheduled 参数可以接受两种定时的设置，
    // 一种是我们常用的cron="*/6 * * * * ?",
    // 一种是 fixedRate = 6000，两种都表示每隔六秒打印一下内容。

    //@Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
    //@Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
    //@Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
    @Scheduled(fixedRate = 2000)
    private void process() {
        String str = "现在时间：" + dateFormat.format(new Date());
        logger.debug(str);
    }

}
