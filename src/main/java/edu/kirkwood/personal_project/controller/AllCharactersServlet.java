package edu.kirkwood.personal_project.controller;


import edu.kirkwood.personal_project.data.CharacterDAO;
import edu.kirkwood.personal_project.model.Character;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/all-characters")
public class AllCharactersServlet extends HttpServlet {

    private static List<Character> characters;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        characters = CharacterDAO.getAll();
        req.setAttribute("characters", characters);
        req.setAttribute("pageTitle", "Characters");
        req.getRequestDispatcher("WEB-INF/personal_project/characters.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        characters = CharacterDAO.getAll();
        String query = req.getParameter("q");
        String sort = req.getParameter("sort");
        String strCharacter= req.getParameter("strCharacter");
        String q = query != null ? query : "";
        sort = sort != null ? sort : "";
        String character = strCharacter != null ? strCharacter : "";


        List<Character> copy = new ArrayList<>(characters);
        if(!q.isBlank()) {
            copy.removeIf(character1 -> !character1.getCharacter_name().toLowerCase().contains(q.toLowerCase()));
        }
        if(!character.isBlank()){
            copy.removeIf(character1 -> !character1.getCharacter_name().equals(character));
        }
        if(sort.equals("az")){
            Collections.sort(copy);
        }
        else{
            copy.sort(Comparator.reverseOrder());
        }
        req.setAttribute("q", q);
        req.setAttribute("s", sort);
        req.setAttribute("strCharacter", strCharacter);
        req.setAttribute("characters", copy);
        req.setAttribute("pageTitle", "Characters");
        req.getRequestDispatcher("WEB-INF/personal_project/characters.jsp").forward(req, resp);
    }
}
