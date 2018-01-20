package com.wkzt.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author hanchao
 * @Data 2017/11/6 17:12
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    private String mpAppId;
    private String mpAppSecret;

    private String openAppId;
    private String openAppSecret;
    private String mchId;
    private String mchKey;
    private String keyPath;
}
