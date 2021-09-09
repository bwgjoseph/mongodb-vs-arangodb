# MongoDB vs ArangoDB

This project focus on comparing features provided between both [MongoDB](https://www.mongodb.com/) and [ArangoDB](https://www.arangodb.com/) for `Java`

Some of the key items that we want to compare are:

- [ ] Feature Parity
  - [ ] CRUD Operations
  - [ ] Bulk Operations
  - [ ] Text Search
  - [ ] Geospatial Queries
  - [ ] Aggregation
  - [ ] Data Model
    - [ ] Schema Validation
  - [ ] Transaction
  - [ ] Indexes
  - [ ] Change streams / events
- [ ] Architecture
  - [ ] Setup
  - [ ] Replication
  - [ ] Sharding
  - [ ] Backups
- [ ] Ease of API usage
  - [ ] Updating partial document (patch)
  - [ ] Updating/Removing item in a array within an document
- [ ] Integration with Spring Boot

## Project Info

- Initialized via [start.spring.io](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.5.4&packaging=jar&jvmVersion=16&groupId=com.bwgjoseph&artifactId=mongodb-vs-arangodb&name=mongodb-vs-arangodb&description=Demo%20project%20for%20Spring%20Boot&packageName=com.bwgjoseph.mongodb-vs-arangodb&dependencies=devtools,lombok,configuration-processor,webflux,data-mongodb-reactive,actuator,testcontainers)
- Uses [AdoptOpenJDK-11-hotspot](https://adoptopenjdk.net/releases.html?variant=openjdk11&jvmVariant=hotspot)
- Uses [docker compose v2](./docker/docker-compose.yaml) to spin up the containers for `MongoDB` and `ArangoDB`
  - See [README](./docker/README.md) for more information

## Testing Strategy

- Test basic CRUD and spring-data features
  - including paging and sorting repository
  - Use `@MongoDataTest`
- Test advance spring-data feature
  - `Criteria`

## Note

### Prematurely reached end of stream error

If you run test, and saw the following errors

```log
2021-09-10 00:29:10.314  INFO 19516 --- [localhost:49172] org.mongodb.driver.cluster               : Exception in monitor thread while connecting to server localhost:49172

com.mongodb.MongoSocketReadException: Prematurely reached end of stream
	at com.mongodb.internal.connection.SocketStream.read(SocketStream.java:112) ~[mongodb-driver-core-4.2.3.jar:na]
SocketStream.java:112
	at com.mongodb.internal.connection.SocketStream.read(SocketStream.java:131) ~[mongodb-driver-core-4.2.3.jar:na]
SocketStream.java:131
	at com.mongodb.internal.connection.InternalStreamConnection.receiveResponseBuffers(InternalStreamConnection.java:647) ~[mongodb-driver-core-4.2.3.jar:na]
InternalStreamConnection.java:647
	at com.mongodb.internal.connection.InternalStreamConnection.receiveMessageWithAdditionalTimeout(InternalStreamConnection.java:512) ~[mongodb-driver-core-4.2.3.jar:na]
InternalStreamConnection.java:512
	at com.mongodb.internal.connection.InternalStreamConnection.receiveCommandMessageResponse(InternalStreamConnection.java:355) ~[mongodb-driver-core-4.2.3.jar:na]
InternalStreamConnection.java:355
	at com.mongodb.internal.connection.InternalStreamConnection.receive(InternalStreamConnection.java:315) ~[mongodb-driver-core-4.2.3.jar:na]
InternalStreamConnection.java:315
	at com.mongodb.internal.connection.DefaultServerMonitor$ServerMonitorRunnable.lookupServerDescription(DefaultServerMonitor.java:215) ~[mongodb-driver-core-4.2.3.jar:na]
DefaultServerMonitor.java:215
	at com.mongodb.internal.connection.DefaultServerMonitor$ServerMonitorRunnable.run(DefaultServerMonitor.java:144) ~[mongodb-driver-core-4.2.3.jar:na]
DefaultServerMonitor.java:144
	at java.base/java.lang.Thread.run(Thread.java:829) ~[na:na]
Thread.java:829

2021-09-10 00:29:10.775  INFO 19516 --- [ionShutdownHook] org.mongodb.driver.connection            : Closed connection [connectionId{localValue:3, serverValue:5}] to localhost:49172 because there was a socket exception raised on another connection from this pool.
```

It means nothing except that the [test containers might have shutdown before the context](https://developer.okta.com/blog/2021/05/19/spring-security-testing). The test will still run correctly