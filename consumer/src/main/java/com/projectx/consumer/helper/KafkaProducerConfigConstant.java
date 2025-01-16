package com.projectx.consumer.helper;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "spring.kafka.producer")
@Configuration
public class KafkaProducerConfigConstant {
    private String bootstrapServer;
    private String schemaRegistryUrl;
    private String requestTimeoutMs;
    private String maxBlockMs;
}
