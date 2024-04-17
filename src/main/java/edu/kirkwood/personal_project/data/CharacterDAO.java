package edu.kirkwood.personal_project.data;

import edu.kirkwood.personal_project.model.Character;
import edu.kirkwood.personal_project.model.UserTwo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CharacterDAO extends Database{
    public static List<Character> getAll(){
        List<Character> characters = new ArrayList<>();
        try (Connection connection = getConnection()) {
            if (connection != null) {
                try (CallableStatement statement = connection.prepareCall("{CALL sp_get_all_characters()}")) {
                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            int id = resultSet.getInt("character_id");
                            String name = resultSet.getString("character_name");
                            String status = resultSet.getString("character_status");
                            int unlock_level = resultSet.getInt("fk_character_unlock_level");
                            Character character = new Character(id, name, status, unlock_level);
                            characters.add(character);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Likely error with stored procedure");
            System.out.println(e.getMessage());
        }
        return characters;
    }

    public static void deleteCharacter(Character character){
        try (Connection connection = getConnection()) {
            if (connection != null) {
                try (CallableStatement statement = connection.prepareCall("{CALL sp_delete_character(?)}")) {
                    statement.setInt(1, character.getCharacter_id());
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
