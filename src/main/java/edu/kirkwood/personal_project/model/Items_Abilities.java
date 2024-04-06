package edu.kirkwood.personal_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items_Abilities {
    @JsonProperty("item_ability_id")
    private int item_ability_ID;

    @JsonProperty("item_ability_name")
    private String item_ability_name;

    @JsonProperty("fk_ability_match_up")
    private int fk_ability_match_up;

    @JsonProperty("fk_item_unlock_level")
    private int fk_item_unlock_level;

    public Items_Abilities() {
    }

    public Items_Abilities(int item_ability_ID, String item_ability_name, int fk_ability_match_up, int fk_item_unlock_level) {
        this.item_ability_ID = item_ability_ID;
        this.item_ability_name = item_ability_name;
        this.fk_ability_match_up = fk_ability_match_up;
        this.fk_item_unlock_level = fk_item_unlock_level;
    }

    public int getItem_ability_ID() {
        return item_ability_ID;
    }

    public String getItem_ability_name() {
        return item_ability_name;
    }

    public int getFk_ability_match_up() {
        return fk_ability_match_up;
    }

    public int getFk_item_unlock_level() {
        return fk_item_unlock_level;
    }

    public void setItem_ability_ID(int item_ability_ID) {
        this.item_ability_ID = item_ability_ID;
    }

    public void setItem_ability_name(String item_ability_name) {
        this.item_ability_name = item_ability_name;
    }

    public void setFk_ability_match_up(int fk_ability_match_up) {
        this.fk_ability_match_up = fk_ability_match_up;
    }

    public void setFk_item_unlock_level(int fk_item_unlock_level) {
        this.fk_item_unlock_level = fk_item_unlock_level;
    }

    @Override
    public String toString() {
        return "Items_Abilities{" +
                "item_ability_ID=" + item_ability_ID +
                ", item_ability_name='" + item_ability_name + '\'' +
                ", fk_ability_match_up=" + fk_ability_match_up +
                ", fk_item_unlock_level=" + fk_item_unlock_level +
                '}';
    }
}
