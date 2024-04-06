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

    public void setGameModeID(int gameModeID) {
        this.gameModeID = gameModeID;
    }

    public void setPvePvp(String pvePvp) {
        this.pvePvp = pvePvp;
    }

    public void setGameModeName(String gameModeName) {
        this.gameModeName = gameModeName;
    }

    public void setGameModeUnlockLevel(int gameModeUnlockLevel) {
        this.gameModeUnlockLevel = gameModeUnlockLevel;
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
