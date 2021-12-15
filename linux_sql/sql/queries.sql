-- Group hosts by hardware info
-- Group hosts by CPU number and sort by their memory size in descending order(within each cpu_number group)
SELECT cpu_number, host_id, total_mem
  FROM host_info
ORDER BY cpu_number, total_mem DESC;

-- a function for convenience purposes so my query looks cleaner
CREATE FUNCTION round5(ts timestamp) RETURNS timestamp AS
    $$
BEGIN
RETURN date_trunc('hour', ts) + date_part('minute', ts):: int / 5 * interval '5 min';
END;
$$
LANGUAGE PLPGSQL;

-- Average memory usage
-- Average used memory in percentage over 5 minutes interval for each host (used memory = total memory - free memory)
SELECT hi.id,
       hi.hostname,
       round5(hu.timestamp) AS ts,
       AVG(((CAST(hi.total_mem AS float) - (hu.memory_free * 1000)) / hi.total_mem) * 100) as avg_used_mem_percentage
FROM   host_usage AS hu
JOIN   host_info AS hi
ON     hu.host_id = hi.id
GROUP BY ts, hi.id
ORDER BY ts, hi.id;

-- Detect host failure
-- The cron job is supposed to insert a new entry to the host_usage table every minute when the server is healthy. We can assume that a server has failed when it inserts less than three data points within a 5-minute interval
SELECT host_id,
       round5(timestamp) AS ts,
       COUNT(*) AS num_data_points
FROM   host_usage
GROUP BY ts, host_id
HAVING   COUNT(*) < 3
ORDER BY ts, host_id;
