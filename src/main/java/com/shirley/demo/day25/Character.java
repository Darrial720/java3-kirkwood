package com.shirley.demo.day25;

public class Character {

    private int characterID;

    private String characterName;

    private String characterStatus;

    private int fk_character_unlock_level;


    public int getCharacterID() {
        return characterID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getCharacterStatus() {
        return characterStatus;
    }

    public int getFk_character_unlock_level() {
        return fk_character_unlock_level;
    }

    public Character(int characterID, String _characterName, String _characterStatus, int fk_character_unlock_level) {
        this.characterID = characterID;
        characterName = _characterName;
        characterStatus = _characterStatus;
        this.fk_character_unlock_level = fk_character_unlock_level;
    }


    @Override
    public String toString() {
        return "Character{" +
                "characterID=" + characterID +
                ", CharacterName='" + characterName + '\'' +
                ", CharacterStatus='" + characterStatus + '\'' +
                ", fk_character_unlock_level=" + fk_character_unlock_level +
                '}';
    }
}
