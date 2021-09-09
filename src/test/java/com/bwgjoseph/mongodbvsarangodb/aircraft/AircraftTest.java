package com.bwgjoseph.mongodbvsarangodb.aircraft;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class AircraftTest {

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:5.0.2")
                                                    .withEnv("MONGO_INIT_DATABASE", "mva")
                                                    .withReuse(true);

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Autowired
    private AircraftRepository aircraftRepository;

    @BeforeEach
    void beforeEach() {
        this.aircraftRepository.deleteAll();
    }

    @Test
    void shouldSaveSingleAircraft() {
        // Given
        Aircraft aircraft = Aircraft.builder()
                                .callsign("c01")
                                .flightNo("f01")
                                .registrationNo("r01")
                                .type("Mega")
                                .altitude(1000)
                                .heading(2000)
                                .speed(3000)
                                .point(new GeoJsonPoint(1.23, 3.45))
                                .build();

        // When
        Aircraft expected = this.aircraftRepository.save(aircraft);

        // Then
        List<Aircraft> actual = this.aircraftRepository.findAll();

        assertThat(actual.size()).isEqualTo(1);
        assertThat(actual.get(0))
            .usingRecursiveComparison()
            .ignoringFields("point")
            .isEqualTo(expected);
    }

}
