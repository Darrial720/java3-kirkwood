package edu.kirkwood.personal_project.controller;


import edu.kirkwood.personal_project.data.CharacterDAO;
import edu.kirkwood.personal_project.model.Character;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/all-characters")
public class AllCharactersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Character> characters = CharacterDAO.getAll();
        req.setAttribute("characters", characters);
        req.setAttribute("pageTitle", "Characters");
        req.getRequestDispatcher("WEB-INF/personal_project/characters.jsp").forward(req, resp);
    }
}
