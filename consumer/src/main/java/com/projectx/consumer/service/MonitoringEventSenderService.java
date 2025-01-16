package com.projectx.consumer.service;

import com.projectx.consumer.helper.WebClientConstant;
import com.projectx.consumer.helper.WikimediaRecordAvroConverter;
import com.projectx.consumer.model.WikimediaRecordEntity;
import com.projectx.producer.dto.WikimediaRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class MonitoringEventSenderService {
    private final WebClient webClient;
    private final WebClientConstant webClientConstant;
    public void sendData(WikimediaRecord data) {
        WikimediaRecordEntity wikimediaRecord = webClient.post()
                .uri(webClientConstant.getMonitoringServiceUrl())
                .bodyValue(WikimediaRecordAvroConverter.convert(data))
                .retrieve()
                .bodyToMono(WikimediaRecordEntity.class)
                .block();

        log.info("Sending record to external service: {}", wikimediaRecord);
    }
}
