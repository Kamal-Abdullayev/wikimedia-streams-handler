package com.projectx.consumer.helper;

public class ConsumerConstant {
    public static final String TOPIC_NAME = "wikimedia.recent-activities";
    public static final String GROUP_ID = "wikimedia.recent-activities.consumer";
    public static final String ATTEMPTS = "4";
    public static final long DELAY = 900;
    public static final double MULTIPLIER = 1000;
    public static final String RETRY_TOPIC_SUFFIX = ".retry";
    public static final String DLT_TOPIC_SUFFIX = ".error";
}
