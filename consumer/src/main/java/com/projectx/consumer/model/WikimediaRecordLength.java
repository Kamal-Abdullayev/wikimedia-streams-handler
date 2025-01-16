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
public class WikimediaRecordLength {
    @JsonProperty("old")
    private long oldLength;

    @JsonProperty("new")
    private long newLength;
}
