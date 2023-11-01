package com.shirley.demo.day21;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DOB {
    @JsonProperty("date")
    private String date;
    @JsonProperty("age")
    private String age;

    @Override
    public String toString() {
        return "{" +
                "date='" + date + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
