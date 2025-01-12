package com.projectx.producer.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class WikimediaRecord {
    @JsonProperty("$schema")
    private String schema; // change

    @JsonProperty("meta")
    private WikimediaMetaRecord wikimediaMetaRecord; // change

    @JsonProperty("id")
    private long id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("title_url")
    private String titleUrl;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("timestamp")
    private long timestamp;
    @JsonProperty("user")
    private String user;
    @JsonProperty("bot")
    private boolean bot;
    @JsonProperty("notify_url")
    private String notifyUrl;
    @JsonProperty("minor")
    private boolean minor;
    @JsonProperty("length")
    private Length length;
    @JsonProperty("revision")
    private Revision revision;
    @JsonProperty("patrolled")
    private boolean patrolled;
    @JsonProperty("server_url")
    private String serverUrl;
    @JsonProperty("server_name")
    private String serverName;
    @JsonProperty("server_script_path")
    private String serverScriptPath;
    @JsonProperty("wiki")
    private String wiki;
    @JsonProperty("parsedcomment")
    private String parsedComment;
}

@ToString
class Length {
    @JsonProperty("old")
    private long oldLength;

    @JsonProperty("new")
    private long newLength;
}

@ToString
class Revision {
    @JsonProperty("old")
    private long oldRevision;

    @JsonProperty("new")
    private long newRevision;
}