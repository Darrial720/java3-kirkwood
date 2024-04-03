package edu.kirkwood.learnx.controller;

import edu.kirkwood.learnx.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/student")
public class StudentDashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
         User userFromSession = (User)session.getAttribute("activeUser");

         if(userFromSession == null || !userFromSession.getPrivileges().equals("student")){
             session.setAttribute("flashMessageWarning", "You must be logged in as a student to view this content");
             resp.sendRedirect("signin?redirect=student");
             return;
         }
         req.setAttribute("pageTitle", "Student Dashboard");
         req.getRequestDispatcher("WEB-INF/learnx/student.jsp").forward(req, resp);
    }
}
