/*
	Darryl Shirley
    12-4-2022
    Final_Project.sql
    Dragon Ball Z video game database



*/



/* Building dbz_game_Database  */

DROP DATABASE IF EXISTS dbz_game_database;
CREATE DATABASE IF NOT EXISTS dbz_game_database;

USE dbz_game_database;


DROP TABLE IF EXISTS player_level;
CREATE TABLE player_level(
	level_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'A unique ID for the player level'
	, character_unlock_level INT NOT NULL COMMENT 'the player level at which a character becomes playable'
	, map_unlock_level INT NOT NULL COMMENT 'The player level at which a map becomes accessible to the player'
	, game_mode_unlock_level INT NOT NULL COMMENT 'The player level at which a game mode becomes accessible to the player'
	, item_unlock_level INT NOT NULL COMMENT 'The level at which an item is unlocked by the player'


) COMMENT 'table holding player level information'
;

INSERT INTO player_level(
    character_unlock_level
    , map_unlock_level
    , game_mode_unlock_level
    , item_unlock_level
)
VALUES(
	1
    , 1
    , 1
    , 1
),
(
	2
    , 2
    , 2
    , 2 
),
(
	3
    , 3
    , 3
    , 3
)
;


DROP TABLE IF EXISTS game_modes;
CREATE TABLE game_modes(
	game_mode_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'A unique ID for the game mode'
	, pve_pvp VARCHAR(50) NOT NULL COMMENT 'Details whether or not a game mode requires player vs. player, player vs. computer, or both'
	, game_mode_name VARCHAR(50) NOT NULL COMMENT 'The name of the game mode'
	, fk_game_mode_unlock_level INT NOT NULL DEFAULT 1 COMMENT 'The player level at which a game mode becomes accessible to the player'
	, FOREIGN KEY(fk_game_mode_unlock_level) REFERENCES player_level(level_id)

) COMMENT 'Table holding game mode specific information'
;

INSERT INTO game_modes(
	pve_pvp
    , game_mode_name

)
VALUES(
	'pve and pvp'
    , 'World Martial Arts Big Tournament'

),
(
	'pve'
    , 'Story Mode'
),
(
	'pvp'
	, 'Online Versus'
)
;


DROP TABLE IF EXISTS characters;
CREATE TABLE characters(
	character_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'identification number for each character'
	, character_name VARCHAR(50) NOT NULL COMMENT 'character name'
	, character_status VARCHAR(50) NOT NULL COMMENT 'Defines whether a character is playable or nonplayable'
	, fk_character_unlock_level INT NOT NULL DEFAULT 1 COMMENT 'the player level at which a character becomes playable'
    , FOREIGN KEY(fk_character_unlock_level) REFERENCES player_level(level_id)
    
) COMMENT 'Table holding Character Specific Information'
;

INSERT INTO characters(
	character_id
	, character_name
    , character_status

)
VALUES(
	1
	, 'Vegeta'
    , 'playable'
),
(
	2
	, 'Gohan'
    , 'playable'
),
(
	3
	, 'Picolo'
    , 'playable'
)
;

DROP TABLE IF EXISTS item_power_ups_abilities;
CREATE TABLE item_power_ups_abilities(
	item_ability_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'A unique ID number for an item/ability'
	, item_ability_name VARCHAR(50) NOT NULL COMMENT 'The name of the item/ability'
	, fk_ability_match_up INT NOT NULL DEFAULT 1 COMMENT 'lists what character can use this ability'
	, fk_item_unlock_level INT NULL DEFAULT 1 COMMENT 'The level at which an item is unlocked by the player'
	, FOREIGN KEY(fk_ability_match_up) REFERENCES characters(character_id)
    , FOREIGN KEY(fk_item_unlock_level) REFERENCES player_level(level_id) 
    
) COMMENT 'Table Holding item and character ability information'
;

INSERT INTO item_power_ups_abilities(
	item_ability_name
)
VALUES(
	'1 star dragon ball'
)
;


DROP TABLE IF EXISTS maps;
CREATE TABLE maps(
	map_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'The unique identifier for a map'
	, player_count INT NOT NULL COMMENT 'The amount of players a map can hold'
    , map_name VARCHAR(50) NOT NULL COMMENT 'Name of the map'
	, fk_map_unlock_level INT NOT NULL DEFAULT 1 COMMENT 'The player level at which a map becomes accessible to the player'
	, fk_map_game_modes INT NOT NULL DEFAULT 1 COMMENT 'Details what game modes the map is accessible through'
	, FOREIGN KEY(fk_map_unlock_level) REFERENCES player_level(level_id)
    , FOREIGN KEY(fk_map_game_modes) REFERENCES game_modes(game_mode_id)

) COMMENT 'Table holding A location where the player moves and interacts with a playable character'
;

DROP TABLE IF EXISTS dbz_audit;
CREATE TABLE dbz_audit(
	character_id INT
    , character_name VARCHAR(50)
    , character_status VARCHAR(50)
    , fk_character_unlock_level INT
    , map_id INT
    , player_count INT
    , map_name VARCHAR(50)
    , fk_map_unlock_level INT
    , fk_map_game_modes INT
    , action_type VARCHAR(50) -- What changed in the invoices table
    , action_date DATETIME -- When did the change happen
    , user_name VARCHAR(256) -- Who did it
) COMMENT 'Table holding changes made to game database'
;
INSERT INTO maps(
	player_count
    , map_name
)
VALUES(
	'2'
    , 'Kamis Lookout'

),
(
	'4'
    , "Frieza's Spaceship"
),
(
	'2'
    , 'Capsule Corp Laboratory'
)
;


/*2 Triggers for dbz_game_Database*/



DELIMITER $$
DROP TRIGGER IF EXISTS tr_characters_after_insert$$
CREATE TRIGGER tr_characters_after_insert
	AFTER UPDATE ON characters
    FOR EACH ROW
    BEGIN
		INSERT INTO dbz_audit(
        	character_id 	
			, character_name
			, character_status
			, fk_character_unlock_level
            , action_type
			, action_date
			, user_name 
            
        ) VALUES (
			NEW.character_id 	
			, NEW.character_name 
			, NEW.character_status 
			, NEW.fk_character_unlock_level
			, 'UPDATED' 
			, NOW()
			, current_user()
        );
    END$$

DELIMITER ;







DELIMITER $$
DROP TRIGGER IF EXISTS tr_maps_after_delete$$
CREATE TRIGGER tr_maps_after_delete
	AFTER DELETE ON maps
    FOR EACH ROW
    BEGIN
		INSERT INTO dbz_audit (
        	map_id 	
			, player_count
			, map_name
			, fk_map_unlock_level
			, fk_map_game_modes 
			, action_type
			, action_date
			, user_name 
 
        ) 
        VALUES(
			OLD.map_id 	
			, OLD.player_count
			, OLD.map_name 
			, OLD.fk_map_unlock_level 
			, OLD.fk_map_game_modes  
			, 'DELETED' 
			, NOW()
			, current_user()
		);
    END$$

DELIMITER ;


/*4 stored procedures with error handling for dbz_game_database*/

DELIMITER $$
DROP PROCEDURE IF EXISTS new_data_for_player_level$$
CREATE PROCEDURE new_data_for_player_level()
COMMENT 'updates data in the player_level table'
BEGIN
	/*
		Copyright statement
		Author: Darryl Shirley
		File:	Final_Project.sql
		
		2022-04-12	Darryl Shirley			
		
	*/
	
UPDATE player_level
SET character_unlock_level = 1
	, map_unlock_level = 1
    , game_mode_unlock_level = 1
    , item_unlock_level = 1
WHERE level_id = 1
;

SELECT 
	*
FROM player_level
WHERE level_id = 1
;
	

	
END$$
DELIMITER ;

CALL new_data_for_player_level();












DELIMITER $$
DROP PROCEDURE IF EXISTS new_data_for_characters$$
CREATE PROCEDURE new_data_for_characters()
COMMENT 'Updates data in the characters table'
BEGIN
	/*
		Copyright statement
		Author: Darryl Shirley
		File:	Final_Project.sql
		
		2022-04-12	Darryl Shirley			
		
	*/
	
UPDATE characters
SET 
	 character_name = 'Goku'
    , character_status = 'playable'
WHERE character_id = 1
;

SELECT 
	*
FROM characters
WHERE fk_character_unlock_level = 1
;

SELECT
	character_id 	
	, character_name
	, character_status
	, fk_character_unlock_level
	, action_type
	, action_date
	, user_name 
FROM dbz_audit
;
	
END$$
DELIMITER ;

CALL new_data_for_characters();



DELIMITER $$
DROP PROCEDURE IF EXISTS remove_data_from_maps$$
CREATE PROCEDURE remove_data_from_maps()
COMMENT 'Removes some data from the maps table'
BEGIN
	/*
		Copyright statement
		Author: Darryl Shirley
		File:	Final_Project.sql
		
		2022-04-12	Darryl Shirley
		
	*/
	
DELETE FROM maps
WHERE map_id = 2
;

SELECT 
	map_id
    , map_name
    , player_count
    , fk_map_unlock_level
	, fk_map_game_modes
FROM maps
;
	
SELECT
	map_id 	
	, player_count
	, map_name
	, fk_map_unlock_level
	, fk_map_game_modes 
	, action_type
	, action_date
	, user_name 
FROM dbz_audit
;    
    
END$$
DELIMITER ;

CALL remove_data_from_maps();



DELIMITER $$
DROP PROCEDURE IF EXISTS insert_data_for_item_power_ups_abilities$$
CREATE PROCEDURE insert_data_for_item_power_ups_abilities()
COMMENT 'inserts new data into the item_power_ups_abilities table'
BEGIN
	/*
		Copyright statement
		Author: Darryl Shirley
		File:	Final_Project.sql
		
		2022-04-12	Darryl Shirley			
		
	*/
	
INSERT INTO item_power_ups_abilities
	(item_ability_id
    , item_ability_name
    , fk_ability_match_up)
VALUES
	(6
    , 'KameHameHa!'
    , 1)
;

SELECT 
	item_ability_id
    , item_ability_name
    , fk_ability_match_up
FROM item_power_ups_abilities
;

	
END$$
DELIMITER ;

CALL insert_data_for_item_power_ups_abilities();









/*2 views for dbz_game_Database*/

CREATE VIEW dbz_game_Database.vw_map_list AS
SELECT
	game_mode_id
    , pve_pvp
    , game_mode_name
    , map_id
    , player_count
    , map_name
FROM game_modes
RIGHT JOIN maps
ON game_modes.game_mode_id = maps.fk_map_game_modes
ORDER BY game_mode_id ASC
;

SELECT 
	game_mode_id
    , pve_pvp
    , game_mode_name
    , map_id
    , player_count
    , map_name
FROM vw_map_list ;










CREATE VIEW dbz_game_Database.vw_items_abilities_list AS
SELECT
	character_id
	, character_name
    , character_status
    , item_ability_id
    , item_ability_name
FROM characters
RIGHT JOIN item_power_ups_abilities
ON characters.character_id = item_power_ups_abilities.fk_ability_match_up
ORDER BY character_name
;

SELECT 
	character_id
	, character_name
    , character_status
    , item_ability_id
    , item_ability_name
FROM vw_items_abilities_list;
