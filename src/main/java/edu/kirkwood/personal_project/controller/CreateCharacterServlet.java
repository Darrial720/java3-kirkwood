package edu.kirkwood.personal_project.controller;

import edu.kirkwood.personal_project.data.CharacterDAO;
import edu.kirkwood.personal_project.model.Character;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/create-character")
public class CreateCharacterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageTitle", "Create Character");
        req.getRequestDispatcher("WEB-INF/personal_project/createCharacter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String characterName = req.getParameter("inputCharacterName");
        String characterStatus = req.getParameter("inputCharacterStatus");
        String characterUnlockLevel= req.getParameter("inputCharacterUnlockLevel");


        Map<String, String> results = new HashMap<>();
        results.put("CharacterName", characterName);
        results.put("CharacterStatus", characterStatus);
        results.put("CharacterUnlockLevel", characterUnlockLevel);

        Character character = new Character();
        try {
            character.setCharacter_name(characterName);
            character.setCharacter_status(characterStatus);
            character.setCharacter_unlock_level(Integer.parseInt(characterUnlockLevel));

            if(CharacterDAO.createCharacter(character) == true){
                results.put("Success", "Character Created successfully");
            }
            else{
                results.put("Creation Failed", "Character not created");
            }
        }
        catch(Exception ex){
            results.put("creationError", ex.getMessage());
        }

        req.setAttribute("results", results);
        req.setAttribute("pageTitle", "Create Character");
        req.getRequestDispatcher("WEB-INF/personal_project/createCharacter.jsp").forward(req, resp);
    }
}
