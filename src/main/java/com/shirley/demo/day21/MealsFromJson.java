package com.shirley.demo.day21;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MealsFromJson {

    @JsonProperty("categories")
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }
}
