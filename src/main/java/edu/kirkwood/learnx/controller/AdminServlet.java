package edu.kirkwood.learnx.controller;

import edu.kirkwood.learnx.data.CourseDAO;
import edu.kirkwood.learnx.model.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courses = CourseDAO.get(8,0,"", "");
        req.setAttribute("courses", courses);
        req.setAttribute("pageTitle", "Admin Dashboard");
        req.getRequestDispatcher("WEB-INF/learnx/all-courses-admin.jsp").forward(req, resp);
    }

}
