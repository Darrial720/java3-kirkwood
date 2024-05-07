package edu.kirkwood.personal_project.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/delete-character")
public class DeleteCharacterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("pageTitle", "Delete Character");
        req.getRequestDispatcher("WEB-INF/personal_project/deleteCharacter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> results = new HashMap<>();
        /*String characterID = req.getParameter()*/


        req.setAttribute("results", results);
        req.setAttribute("pageTitle", "Delete Character");
        req.getRequestDispatcher("WEB-INF/personal_project/deleteCharacter.jsp").forward(req, resp);
    }
}
