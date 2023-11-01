package com.shirley.demo.day21;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Id {
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;

    @Override
    public String toString() {
        return "Id{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
