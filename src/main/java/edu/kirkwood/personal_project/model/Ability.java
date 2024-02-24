package edu.kirkwood.personal_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Ability {
    @JsonProperty("item_ability_id")
    private int abilityID;

    @JsonProperty("item_ability_name")
    private String abilityName;

    @JsonProperty("fk_ability_match_up")
    private int abilityMatchUp;

    @JsonProperty("fk_item_unlock_level")
    private int abilityUnlockLevel;

    public int getAbilityID() {
        return abilityID;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public int getAbilityMatchUp() {
        return abilityMatchUp;
    }

    public int getAbilityUnlockLevel() {
        return abilityUnlockLevel;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "abilityID=" + abilityID +
                ", abilityName='" + abilityName + '\'' +
                ", abilityMatchUp=" + abilityMatchUp +
                ", abilityUnlockLevel=" + abilityUnlockLevel +
                '}';
    }
}
