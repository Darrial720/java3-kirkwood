package edu.kirkwood.personal_project.data;


import edu.kirkwood.personal_project.model.Map;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MapDAO extends Database{
    public static List<Map> getALL(){
        List<Map> maps = new ArrayList<>();
        try (Connection connection = getConnection()) {
            if (connection != null) {
                try (CallableStatement statement = connection.prepareCall("{CALL sp_get_all_maps()}")) {
                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            int id = resultSet.getInt("map_id");
                            int playerCount = resultSet.getInt("player_count");
                            String name = resultSet.getString("map_name");
                            int unlock_level = resultSet.getInt("fk_map_unlock_level");
                            int map_game_modes = resultSet.getInt("fk_map_game_modes");
                            Map map = new Map(id, playerCount, name, unlock_level, map_game_modes);
                            maps.add(map);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Likely error with stored procedure");
            System.out.println(e.getMessage());
        }
        return maps;
    }
}
