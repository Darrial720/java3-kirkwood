package edu.kirkwood.personal_project.controller;


import edu.kirkwood.personal_project.data.Items_AbilitesDAO;
import edu.kirkwood.personal_project.model.Items_Abilities;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/all-abilities-items")
public class All_Abilities_Items_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Items_Abilities> ItemsAbilities = Items_AbilitesDAO.getAll();
        req.setAttribute("ItemsAbilities", ItemsAbilities);
        req.setAttribute("pageTitle", "Items and Abilities");
        req.getRequestDispatcher("WEB-INF/personal_project/abilities-items.jsp").forward(req, resp);
    }
}
