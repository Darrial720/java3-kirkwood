package edu.kirkwood.personal_project.controller;


import edu.kirkwood.personal_project.data.UserDAOTwo;
import edu.kirkwood.personal_project.model.UserTwo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/all-players")
public class AllPlayersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserTwo userFromSession = (UserTwo)session.getAttribute("activeUser");
        if(userFromSession == null || !userFromSession.getStatus().equals("active") || !userFromSession.getPrivileges().equals("admin")){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        List<UserTwo> users = UserDAOTwo.getAll();
        req.setAttribute("users", users);
        req.setAttribute("pageTitle", "All Users");
        req.getRequestDispatcher("WEB-INF/personal_project/all-players.jsp").forward(req, resp);
    }
}
