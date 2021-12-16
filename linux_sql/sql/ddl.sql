-- switch to `host_agent`
\c host_agent;

-- create `host_info` table if not exist
CREATE TABLE IF NOT EXISTS PUBLIC.host_info
(
    id               SERIAL NOT NULL,
    hostname         VARCHAR NOT NULL,
    cpu_number       INT NOT NULL,
    cpu_architecture VARCHAR NOT NULL,
    cpu_model        VARCHAR NOT NULL,
    cpu_mhz          FLOAT(3) NOT NULL,
    L2_cache         INT NOT NULL,
    total_mem        INT NOT NULL,
    "timestamp"      TIMESTAMP NOT NULL,
    -- primary key constraint
    CONSTRAINT PK_host_info PRIMARY KEY (id),
    -- unique hostname constraint
    CONSTRAINT UQ_host_info_hostname UNIQUE (hostname)
);

-- create `host_usage` table if not exist
CREATE TABLE IF NOT EXISTS PUBLIC.host_usage
(
    "timestamp"    TIMESTAMP NOT NULL,
    host_id        SERIAL NOT NULL,
    memory_free    INT NOT NULL,
    cpu_idle       INT NOT NULL,
    cpu_kernel     INT NOT NULL,
    disk_io        INT NOT NULL,
    disk_available INT NOT NULL,
    -- foreign key constraint
    CONSTRAINT FK_host_usage_host_info FOREIGN KEY (host_id) REFERENCES host_info(id)
);