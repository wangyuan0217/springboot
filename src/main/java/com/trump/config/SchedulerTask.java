package com.trump.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * test 定时任务
 */
@Component
public class SchedulerTask {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private String url = "http://www.dsyun.com:7070/dashengyun/app.php/remarks/remark";

    //周一-周五的每天8:55
    @Scheduled(cron = "0 55 8 * * MON-FRI")
    private void checkIn() {
        //10*60*1000 十分钟
        try {
            logger.error("CheckIn begin");
            int delay = new Random().nextInt(10 * 60 * 1000);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error("CheckIn Thread sleep error stackTrace", e.getStackTrace());
                logger.error("CheckIn Thread sleep error message", e.getMessage());
            }
            RestTemplate restTemplate = new RestTemplate();
            String body = restTemplate.getForObject(url, String.class, getParamMap(1));
            logger.error("checkin success" + body);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("CheckIn error stackTrace", e.getStackTrace());
            logger.error("CheckIn error message", e.getMessage());
        }
    }

    //周一-周五的每天8:55
    @Scheduled(cron = "20 29 18 * * MON-FRI")
    private void checkOut() {
        //10*60*1000 十分钟
        try {
            logger.error("checkOut begin");
            int delay = new Random().nextInt(1 * 60 * 1000);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error("checkOut Thread sleep error stackTrace", e.getStackTrace());
                logger.error("checkOut Thread sleep error message", e.getMessage());
            }
            RestTemplate restTemplate = new RestTemplate();
            String body = restTemplate.getForObject(url, String.class, getParamMap(2));
            logger.error("checkOut success" + body);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("checkOut error stackTrace", e.getStackTrace());
            logger.error("checkOut error message", e.getMessage());
        }
    }

    public Map<String, String> getParamMap(int type) {
        Map<String, String> param = new HashMap<>();
        param.put("uid", "26549");
        param.put("type", type + "");
        param.put("area", "新华汇");
        param.put("rule", "{\"area\":\"南京市雨花台区新华汇\",\"lon\":118.773535,\"lat\":31.981668,\"range\":\"300\",\"is_range\":1,\"range_use\":47}");
        param.put("imei", "868809027457691");
        param.put("lat", "31.975454");
        param.put("lon", "118.767414");
        return param;
    }

}
