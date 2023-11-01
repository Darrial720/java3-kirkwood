package com.shirley.demo.day21;

import com.fasterxml.jackson.annotation.JsonProperty;

class Coordinates {
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;

    @Override
    public String toString() {
        return "{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
