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
