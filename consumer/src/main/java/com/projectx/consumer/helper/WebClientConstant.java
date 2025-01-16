package com.projectx.consumer.helper;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "client")
@Component
public class WebClientConstant {
    private String monitoringServiceUrl;

}