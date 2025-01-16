package com.projectx.consumer.helper;

import com.projectx.consumer.model.WikimediaRecordLength;
import com.projectx.consumer.model.WikimediaRecordRevision;
import com.projectx.consumer.model.WikimediaMetaRecord;
import com.projectx.consumer.model.WikimediaRecordEntity;
import com.projectx.producer.dto.Length;
import com.projectx.producer.dto.Revision;
import com.projectx.producer.dto.WikimediaRecord;

public class WikimediaRecordAvroConverter {

    public static WikimediaRecordEntity convert(final WikimediaRecord wikimediaRecord) {
        return WikimediaRecordEntity.builder()
                .id(wikimediaRecord.getId())
                .type(wikimediaRecord.getType())
                .title(wikimediaRecord.getTitle())
                .titleUrl(wikimediaRecord.getTitleUrl())
                .comment(wikimediaRecord.getComment())
                .timestamp(wikimediaRecord.getTimestamp())
                .user(wikimediaRecord.getUser())
                .bot(wikimediaRecord.getBot())
                .notifyUrl(wikimediaRecord.getNotifyUrl())
                .minor(wikimediaRecord.getMinor())
                .patrolled(wikimediaRecord.getPatrolled())
                .serverUrl(wikimediaRecord.getServerUrl())
                .serverName(wikimediaRecord.getServerName())
                .serverScriptPath(wikimediaRecord.getServerScriptPath())
                .wiki(wikimediaRecord.getWiki())
                .parsedComment(wikimediaRecord.getComment())
                .wikimediaMetaRecord(WikimediaMetaRecord.builder()
                        .uri(wikimediaRecord.getMeta().getUri())
                        .requestId(wikimediaRecord.getMeta().getRequestId())
                        .id(wikimediaRecord.getMeta().getId())
                        .dateTime(wikimediaRecord.getMeta().getDt())
                        .domain(wikimediaRecord.getMeta().getDomain())
                        .stream(wikimediaRecord.getMeta().getStream())
                        .topic(wikimediaRecord.getMeta().getTopic())
                        .partition(wikimediaRecord.getMeta().getPartition())
                        .offset(wikimediaRecord.getMeta().getOffset())
                        .build())
                .wikimediaRecordLength(wikimediaRecordLengthConverter(wikimediaRecord.getLength()))
                .wikimediaRecordRevision(wikimediaRecordRevisionConverter(wikimediaRecord.getRevision()))
                .build();
    }

    private static WikimediaRecordLength wikimediaRecordLengthConverter(Length length) {
        if (length == null) {
            return null;
        }
        return WikimediaRecordLength.builder()
                .oldLength(length.getOld() == null ? -1 : length.getOld())
                .newLength(length.getNew$())
                .build();
    }

    private static WikimediaRecordRevision wikimediaRecordRevisionConverter(Revision revision) {
        if (revision == null) {
            return null;
        }
        return WikimediaRecordRevision.builder()
                .oldRevision(revision.getOld() == null ? -1 : revision.getOld())
                .newRevision(revision.getNew$())
                .build();
    }
}
