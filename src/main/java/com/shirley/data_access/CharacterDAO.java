package com.shirley.data_access;

import com.shirley.demo.day25.Character;
import com.shirley.demo.day25.User;
import kotlin.text.CharCategory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacterDAO extends Database{
    public static void main(String[] args) throws SQLException {

        getAll().forEach(System.out::println);
    }

    public static List<Character> getAll(){
        List<Character> characters = new ArrayList<>();
        try (Connection connection = getConnection()){
            if(connection != null){
                try(
                        //Statement statement = connection.createStatement();
                        //ResultSet resultSet = statement.executeQuery("SELECT * FROM user;");

                        //gives the same thing as before
                        CallableStatement statement = connection.prepareCall("{CALL sp_get_all_characters()}");
                        ResultSet resultSet = statement.executeQuery();
                ){

                    while(resultSet.next()){
                        int characterID = resultSet.getInt("character_id");
                        String characterName = resultSet.getString("character_name");
                        String characterStatus = resultSet.getString("character_status");
                        int characterUnlockLevel = resultSet.getInt("fk_character_unlock_level");


                        Character character = new Character(characterID,characterName, characterStatus, characterUnlockLevel);
                        characters.add(character);

                    }
                }
            }
        }catch (SQLException e) {
            showError(e);
        }
        return characters;
    }

}
