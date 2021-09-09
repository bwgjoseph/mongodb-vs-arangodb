package com.bwgjoseph.mongodbvsarangodb.aircraft;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {
    private String callsign;
    private String flightNo;
    private String registrationNo;
    private String type;
    private int altitude;
    private int heading;
    private int speed;
    private GeoJsonPoint point;
}
