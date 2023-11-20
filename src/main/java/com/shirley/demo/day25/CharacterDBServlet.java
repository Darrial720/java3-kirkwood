package com.shirley.demo.day25;

import com.shirley.data_access.CharacterDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "characterDBServlet", value = "/characters-db")
public class CharacterDBServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("characters", CharacterDAO.getAll());
        req.getRequestDispatcher("WEB-INF/day25/characters-db.jsp").forward(req, resp);
    }
}
