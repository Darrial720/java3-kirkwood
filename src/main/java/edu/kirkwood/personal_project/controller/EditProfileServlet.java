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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/edit-profile-servlet")
public class EditProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserTwo userFromSession = (UserTwo)session.getAttribute("activeUser");
        if(userFromSession == null) {
            // Redirect non-logged in user to login page
            session.setAttribute("flashMessageWarning", "You must be logged in to view this content.");
            resp.sendRedirect("signin?redirect=edit-profile-servlet");
            return;
        }
        req.setAttribute("pageTitle", "Edit profile");
        req.getRequestDispatcher("WEB-INF/personal_project/edit-profile.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstNameInput");
        String lastName = req.getParameter("lastNameInput");
        String language = req.getParameter("languageInput");
        String timezone = req.getParameter("timezoneInput");

        HttpSession session = req.getSession();
        UserTwo userFromSession = (UserTwo)session.getAttribute("activeUser");

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
            UserDAOTwo.update(userFromSession);
            session.setAttribute("language", userFromSession.getLanguage());
            session.setAttribute("activeUser", userFromSession);
            session.setAttribute("flashMessageSuccess", "Your profile was updated.");
        } else {
            session.setAttribute("flashMessageWarning", "Your profile was not updated. Try again later.");
        }

        req.setAttribute("results", results);
        req.setAttribute("pageTitle", "Edit profile");
        req.getRequestDispatcher("WEB-INF/personal_project/edit-profile.jsp").forward(req, resp);
    }
}

