package com.projectx.consumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class WikimediaMetaRecord {
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("dt")
    private LocalDateTime dateTime;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("stream")
    private String stream;
    @JsonProperty("topic")
    private String topic;
    @JsonProperty("partition")
    private int partition;
    @JsonProperty("offset")
    private long offset;
}
