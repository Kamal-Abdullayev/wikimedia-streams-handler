package com.projectx.producer.service;

import com.projectx.producer.dto.WikimediaRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service

@Slf4j
public class WikimediaStreamService {
    private static final String WIKIMEDIA_URL = "https://stream.wikimedia.org/v2/stream/recentchange";
    private final WebClient webClient;
    private Disposable streamSubscription;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public WikimediaStreamService(WebClient.Builder webClientBuilder, KafkaTemplate<String, Object> kafkaTemplate) {
        this.webClient = webClientBuilder.baseUrl(WIKIMEDIA_URL).build();
        this.kafkaTemplate = kafkaTemplate;
    }

    public void startStream() {
        Flux<WikimediaRecord> eventStream = webClient.get()
                .retrieve()
                .bodyToFlux(WikimediaRecord.class);

        streamSubscription = eventStream.subscribe(
                data -> {
                    log.info("Received event: {}", data);
                    kafkaTemplate.send("wikimedia.recent-activities", UUID.randomUUID().toString(), data);
                },
                error -> log.error("Error in Wikimedia stream: ", error),
                () -> log.info("Wikimedia stream completed.")
        );
    }

    public void stopStream() {
        if (streamSubscription != null && !streamSubscription.isDisposed()) {
            streamSubscription.dispose();
            log.info("Stream subscription disposed.");
        } else {
            log.info("Stream is already stopped or was never started.");
        }
    }


}
