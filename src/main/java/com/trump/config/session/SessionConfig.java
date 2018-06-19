package com.trump.config.session;

//@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 30)
public class SessionConfig {
    //设置Session失效时间，使用Redis Session之后，
    // 原Boot的server.session.timeout属性不再生效
}