package edu.kirkwood.personal_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Game_mode {
    @JsonProperty("gameModeID")
    private int gameModeID;

    @JsonProperty("pve_pvp")
    private String pvePvp;

    @JsonProperty("game_mode_name")
    private String gameModeName;

    @JsonProperty("fk_game_mode_unlock_level")
    private int gameModeUnlockLevel;

    public int getGameModeID() {
        return gameModeID;
    }

    public String getPvePvp() {
        return pvePvp;
    }

    public String getGameModeName() {
        return gameModeName;
    }

    public int getGameModeUnlockLevel() {
        return gameModeUnlockLevel;
    }

    @Override
    public String toString() {
        return "Game_mode{" +
                "gameModeID=" + gameModeID +
                ", pvePvp='" + pvePvp + '\'' +
                ", gameModeName='" + gameModeName + '\'' +
                ", gameModeUnlockLevel=" + gameModeUnlockLevel +
                '}';
    }
}
