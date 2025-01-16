package com.projectx.monitoring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WikimediaRecordLength {
    @JsonProperty("old")
    private long oldLength;

    @JsonProperty("new")
    private long newLength;
}
