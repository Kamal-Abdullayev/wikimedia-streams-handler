package com.projectx.consumer.service;

import com.projectx.producer.dto.WikimediaRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableKafka
public class WikimediaConsumerService {

//    @KafkaListener(topics = {"wikimedia.recent-activities"}, groupId = "consumer-1")
//    public void listener(WikimediaRecord wikimediaRecord) {
//        log.info("Received message: {}", wikimediaRecord);
//    }

}
