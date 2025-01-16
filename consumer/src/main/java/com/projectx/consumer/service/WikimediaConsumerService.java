package com.projectx.consumer.service;

import com.projectx.consumer.helper.ConsumerConstant;
import com.projectx.producer.dto.WikimediaRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableKafka
public class WikimediaConsumerService {
    private final MonitoringEventSenderService monitoringEventSenderService;

    @RetryableTopic(include = {NullPointerException.class},
            attempts = ConsumerConstant.ATTEMPTS,
            backoff = @Backoff(delay = ConsumerConstant.DELAY, multiplier = ConsumerConstant.MULTIPLIER),
            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE,
            retryTopicSuffix = ConsumerConstant.RETRY_TOPIC_SUFFIX,
            dltTopicSuffix = ConsumerConstant.DLT_TOPIC_SUFFIX)
    @KafkaListener(topics = {ConsumerConstant.TOPIC_NAME}, groupId = ConsumerConstant.GROUP_ID)
    public void listener(@Payload WikimediaRecord wikimediaRecord) {
        log.info("Received message: {}", wikimediaRecord.getId());
        monitoringEventSenderService.sendData(wikimediaRecord);
    }

}
