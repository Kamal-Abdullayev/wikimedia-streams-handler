CREATE TABLE wikimedia_meta_record (
                                       wikimedia_meta_record_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       uri VARCHAR(255),
                                       request_id VARCHAR(255),
                                       id VARCHAR(255),
                                       meta_update_time VARCHAR(255),
                                       domain VARCHAR(255),
                                       stream VARCHAR(255),
                                       topic VARCHAR(255),
                                       partition INT,
                                       `offset` BIGINT
);

-- Create table for `Length`
CREATE TABLE length (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        old_length BIGINT,
                        new_length BIGINT
);

-- Create table for `Revision`
CREATE TABLE revision (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          old_revision BIGINT,
                          new_revision BIGINT
);

-- Create table for `WikimediaRecord`
CREATE TABLE wikimedia_record (
                                  wikimedia_record_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  id BIGINT,
                                  type VARCHAR(255),
                                  title VARCHAR(255),
                                  title_url VARCHAR(255),
                                  comment TEXT,
                                  timestamp BIGINT,
                                  wikimedia_user VARCHAR(255),
                                  bot BOOLEAN,
                                  notify_url VARCHAR(255),
                                  minor BOOLEAN,
                                  patrolled BOOLEAN,
                                  server_url VARCHAR(255),
                                  server_name VARCHAR(255),
                                  server_script_path VARCHAR(255),
                                  wiki VARCHAR(255),
                                  parsedcomment TEXT,
                                  meta_id BIGINT,
                                  length_id BIGINT,
                                  revision_id BIGINT,
                                  FOREIGN KEY (meta_id) REFERENCES wikimedia_meta_record(wikimedia_meta_record_id) ON DELETE CASCADE,
                                  FOREIGN KEY (length_id) REFERENCES length(id) ON DELETE CASCADE,
                                  FOREIGN KEY (revision_id) REFERENCES revision(id) ON DELETE CASCADE
);
