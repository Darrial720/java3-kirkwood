package edu.kirkwood.learnx.controller;

import edu.kirkwood.learnx.data.JobApplicationDAO;
import edu.kirkwood.learnx.model.JobApplication;
import edu.kirkwood.learnx.model.User;
import edu.kirkwood.shared.Helpers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/applications")
public class AllApplicationsServlet extends HttpServlet {
    private static List<JobApplication> jobApplications;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userFromSession = Helpers.getUsersFromSession(req);
        if(Helpers.isAdmin(userFromSession) == false) {

            resp.sendRedirect("signin?redirect=applications");
            return;
        }
        jobApplications = JobApplicationDAO.getAll();
        req.setAttribute("applications", jobApplications);
        req.setAttribute("pageTitle", "All Job Applications");
        req.getRequestDispatcher("WEB-INF/learnx/all-applications.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
