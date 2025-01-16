package com.projectx.consumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WikimediaRecordRevision {
    @JsonProperty("old")
    private long oldRevision;

    @JsonProperty("new")
    private long newRevision;
}