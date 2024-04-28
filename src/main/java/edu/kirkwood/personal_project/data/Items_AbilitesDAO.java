package edu.kirkwood.personal_project.data;

import edu.kirkwood.personal_project.model.Character;
import edu.kirkwood.personal_project.model.Items_Abilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Items_AbilitesDAO extends Database{
    public static List<Items_Abilities> getAll(){
        List<Items_Abilities> items_abilities = new ArrayList<>();
        try (Connection connection = getConnection()) {
            if (connection != null) {
                try (CallableStatement statement = connection.prepareCall("{CALL sp_get_all_items_abilities()}")) {
                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            int id = resultSet.getInt("item_ability_id");
                            String name = resultSet.getString("item_ability_name");
                            int matchUp = resultSet.getInt("fk_ability_match_up");
                            int unlock_level = resultSet.getInt("fk_item_unlock_level");
                            Items_Abilities item_Ability = new Items_Abilities(id, name, matchUp, unlock_level);
                            items_abilities.add(item_Ability);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Likely error with stored procedure");
            System.out.println(e.getMessage());
        }
        return items_abilities;
    }

}
