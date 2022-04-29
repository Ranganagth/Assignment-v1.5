CREATE KEYSPACE IF NOT EXISTS cassdb111 WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

USE cassdb111;