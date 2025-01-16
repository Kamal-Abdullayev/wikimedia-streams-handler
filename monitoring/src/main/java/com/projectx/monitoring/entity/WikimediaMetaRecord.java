package com.projectx.monitoring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WikimediaMetaRecord {
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("dt")
    private String dateTime;
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
