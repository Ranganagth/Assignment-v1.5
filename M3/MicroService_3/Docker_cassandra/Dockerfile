FROM cassandra:3.11
ENV CASSANDRA_KEYSPACE cassdb
ENV TABLE user
COPY entrypoint-wrap.sh /entrypoint-wrap.sh
ENTRYPOINT ["/entrypoint-wrap.sh"]
CMD ["cassandra", "-f"]

EXPOSE 9042

