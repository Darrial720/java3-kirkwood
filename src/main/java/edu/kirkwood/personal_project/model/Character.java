package edu.kirkwood.personal_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public class Character implements Comparable<Character>{
    @JsonProperty("character_id")
    private int character_id;

    @JsonProperty("character_name")
    private String character_name;

    @JsonProperty("character_status")
    private String character_status;

    @JsonProperty("fk_character_unlock_level")
    private int character_unlock_level;

    public Character(){

    }
    public Character(int character_id, String character_name, String character_status, int character_unlock_level){
        this.character_id = character_id;
        this.character_name = character_name;
        this.character_status = character_status;
        this.character_unlock_level = character_unlock_level;
    }

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

    public void setCharacter_id(int character_id) {
        this.character_id = character_id;
    }

    public void setCharacter_name(String character_name) {
        this.character_name = character_name;
    }

    public void setCharacter_status(String character_status) {
        this.character_status = character_status;
    }

    public void setCharacter_unlock_level(int character_unlock_level) {
        this.character_unlock_level = character_unlock_level;
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

    @Override
    public int compareTo(@NotNull Character o) {
        int result = this.getCharacter_name().compareTo(o.getCharacter_name());
        if(result == 0){
            result = this.getCharacter_status().compareTo(o.getCharacter_status());
        }
        return result;
    }
}
