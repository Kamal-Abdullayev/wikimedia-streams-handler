package com.projectx.monitoring.service;

import com.projectx.monitoring.entity.WikimediaRecordEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class WikimediaStreamService {

    public void consumeData(WikimediaRecordEntity record) {
        log.info("Received record from consumer: {}", record);
    }
}
