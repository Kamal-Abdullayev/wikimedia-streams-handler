package com.projectx.monitoring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WikimediaRecordRevision {
    @JsonProperty("old")
    private long oldRevision;

    @JsonProperty("new")
    private long newRevision;
}