package edu.kirkwood.learnx.controller;

import edu.kirkwood.learnx.data.UserDAO;
import edu.kirkwood.learnx.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/edit-profile")
public class EditProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userFromSession = (User)session.getAttribute("activeUser");
        if(userFromSession == null){
            session.setAttribute("flashMessageWarning", "You must be logged in to view this content.");
            resp.sendRedirect("signin?redirect=edit-profile");
            return;
        }
        req.setAttribute("pageTitle", "Edit profile");
        req.getRequestDispatcher("WEB-INF/learnx/edit-profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("emailInput");
        String phone = req.getParameter("phoneInput");
        String language = req.getParameter("languageInput");
        String timezone = req.getParameter("timezoneInput");

        HttpSession session = req.getSession();
        User userFromSession =(User)session.getAttribute("activeUser");

        Map<String, String> results = new HashMap<>();

        userFromSession.setFirstName(firstName);
        userFromSession.setLastName(lastName);
        try {
            userFromSession.setLanguage(language);
        } catch(IllegalArgumentException e) {
            results.put("languageError", e.getMessage());
        }
        // To-do add timeZone property

        if(!results.containsKey("languageError")) {
            UserDAO.update(userFromSession);
            session.setAttribute("activeUser", userFromSession);
            session.setAttribute("flashMessageSuccess", "Your Profile was updated");
        }
        else{
            session.setAttribute("flashMessageWarning", "Your profile was not updated. Try again later.");
        }



        UserDAO.update(userFromSession);
        session.setAttribute("activeUser", userFromSession);

        req.setAttribute("pageTitle", "Edit profile");
        req.getRequestDispatcher("WEB-INF/learnx/edit-profile.jsp").forward(req, resp);

    }
}
