package edu.kirkwood.personal_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Map {
    @JsonProperty("map_id")
    private int mapID;

    @JsonProperty("player_count")
    private int playerCount;

    @JsonProperty("map_name")
    private String mapName;

    @JsonProperty("fk_map_unlock_level")
    private int mapUnlockLevel;

    @JsonProperty("fk_map_game_modes")
    private int mapGameModes;

    public Map() {
    }

    public Map(int mapID, int playerCount, String mapName, int mapUnlockLevel, int mapGameModes) {
        this.mapID = mapID;
        this.playerCount = playerCount;
        this.mapName = mapName;
        this.mapUnlockLevel = mapUnlockLevel;
        this.mapGameModes = mapGameModes;
    }

    public int getMapID() {
        return mapID;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public String getMapName() {
        return mapName;
    }

    public int getMapUnlockLevel() {
        return mapUnlockLevel;
    }

    public int getMapGameModes() {
        return mapGameModes;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public void setMapUnlockLevel(int mapUnlockLevel) {
        this.mapUnlockLevel = mapUnlockLevel;
    }

    public void setMapGameModes(int mapGameModes) {
        this.mapGameModes = mapGameModes;
    }

    @Override
    public String toString() {
        return "Map{" +
                "mapID=" + mapID +
                ", playerCount=" + playerCount +
                ", mapName='" + mapName + '\'' +
                ", mapUnlockLevel=" + mapUnlockLevel +
                ", mapGameModes=" + mapGameModes +
                '}';
    }
}
