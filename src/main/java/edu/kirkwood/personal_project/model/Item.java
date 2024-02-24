package edu.kirkwood.personal_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    @JsonProperty("item_ability_id")
    private int itemID;

    @JsonProperty("item_ability_name")
    private String itemName;

    @JsonProperty("fk_ability_match_up")
    private int itemMatchUp;

    @JsonProperty("fk_item_unlock_level")
    private int itemUnlockLevel;

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemMatchUp() {
        return itemMatchUp;
    }

    public int getItemUnlockLevel() {
        return itemUnlockLevel;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", itemMatchUp=" + itemMatchUp +
                ", itemUnlockLevel=" + itemUnlockLevel +
                '}';
    }
}
