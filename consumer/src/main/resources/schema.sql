CREATE TABLE wikimedia_meta_record (
                                       wikimedia_meta_record_id BIGSERIAL PRIMARY KEY,
                                       uri VARCHAR(255),
                                       request_id VARCHAR(255),
                                       id VARCHAR(255),
                                       meta_update_time TIMESTAMP,
                                       domain VARCHAR(255),
                                       stream VARCHAR(255),
                                       topic VARCHAR(255),
                                       "partition" INT,
                                       "offset" BIGINT
);

CREATE TABLE length (
                        id BIGSERIAL PRIMARY KEY,
                        old_length BIGINT,
                        new_length BIGINT
);

CREATE TABLE revision (
                          id BIGSERIAL PRIMARY KEY,
                          old_revision BIGINT,
                          new_revision BIGINT
);

CREATE TABLE wikimedia_record (
                                  wikimedia_record_id BIGSERIAL PRIMARY KEY,
                                  id BIGINT,
                                  type VARCHAR(255),
                                  title VARCHAR(255),
                                  title_url VARCHAR(255),
                                  comment TEXT,
                                  timestamp BIGINT,
                                  "user" VARCHAR(255),
                                  bot BOOLEAN,
                                  notify_url VARCHAR(255),
                                  minor BOOLEAN,
                                  patrolled BOOLEAN,
                                  server_url VARCHAR(255),
                                  server_name VARCHAR(255),
                                  server_script_path VARCHAR(255),
                                  wiki VARCHAR(255),
                                  parsedcomment TEXT,
                                  meta_id VARCHAR(255),
                                  length_id BIGINT,
                                  revision_id BIGINT
);

ALTER TABLE wikimedia_record ADD COLUMN meta JSONB;
ALTER TABLE wikimedia_record ADD COLUMN namespace INT DEFAULT 0;
ALTER TABLE wikimedia_record ADD COLUMN length JSONB;
ALTER TABLE wikimedia_record ADD COLUMN revision JSONB;
ALTER TABLE wikimedia_record ADD COLUMN old_length BIGINT;
ALTER TABLE wikimedia_record ADD COLUMN new_length BIGINT;
ALTER TABLE wikimedia_record ADD COLUMN meta_partition INT DEFAULT 0;
ALTER TABLE wikimedia_record ADD COLUMN meta_uri VARCHAR(255) DEFAULT '';
ALTER TABLE wikimedia_record ADD COLUMN meta_offset BIGINT DEFAULT 0;
ALTER TABLE wikimedia_record ADD COLUMN meta_domain VARCHAR(255) DEFAULT '';
ALTER TABLE wikimedia_record ADD COLUMN meta_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE wikimedia_record ADD COLUMN meta_stream VARCHAR(255) DEFAULT '';
ALTER TABLE wikimedia_record ADD COLUMN meta_dt VARCHAR(255) DEFAULT '';
ALTER TABLE wikimedia_record ADD COLUMN meta_topic VARCHAR(255) DEFAULT 'default_value';
