package edu.kirkwood.personal_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Character {
    @JsonProperty("character_id")
    private int character_id;

    @JsonProperty("character_name")
    private String character_name;

    @JsonProperty("character_status")
    private String character_status;

    @JsonProperty("fk_character_unlock_level")
    private int character_unlock_level;

    public int getCharacter_id() {
        return character_id;
    }

    public String getCharacter_name() {
        return character_name;
    }

    public String getCharacter_status() {
        return character_status;
    }

    public int getCharacter_unlock_level() {
        return character_unlock_level;
    }

    @Override
    public String toString() {
        return "Character{" +
                "character_id=" + character_id +
                ", character_name='" + character_name + '\'' +
                ", character_status='" + character_status + '\'' +
                ", character_unlock_level=" + character_unlock_level +
                '}';
    }
}
