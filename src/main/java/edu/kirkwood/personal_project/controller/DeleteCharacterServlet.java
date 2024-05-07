package edu.kirkwood.personal_project.controller;

import edu.kirkwood.personal_project.data.CharacterDAO;
import edu.kirkwood.personal_project.model.Character;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/delete-character")
public class DeleteCharacterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        Character character1 = new Character();
        List<Character> characterList = CharacterDAO.getAll();
        Map<String, String> results = new HashMap<>();
        for(Character character : characterList){
            if(character.getCharacter_id() == id){
                character1 = character;
            }
        }
        req.setAttribute("id", idStr);
        req.setAttribute("pageTitle", "Delete Character");
        req.setAttribute("character",character1);
        req.getRequestDispatcher("WEB-INF/personal_project/deleteCharacter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        Character character1 = new Character();
        List<Character> characterList = CharacterDAO.getAll();
        Map<String, String> results = new HashMap<>();
        for(Character character : characterList){
            if(character.getCharacter_id() == id){
                character1 = character;
            }
        }

        if(character1.getCharacter_name() != null){
            CharacterDAO.deleteCharacter(character1);
            results.put("Success", "Character Successfully deleted");

        }
        else{
            results.put("deletionError", "Character deletion failed");
        }

        req.setAttribute("id", idStr);
        req.setAttribute("character",character1);
        req.setAttribute("results", results);
        req.setAttribute("pageTitle", "Delete Character");
        req.getRequestDispatcher("WEB-INF/personal_project/deleteCharacter.jsp").forward(req, resp);
    }
}
