package edu.kirkwood.learnx.controller;

import edu.kirkwood.learnx.data.JobListingDAO;
import edu.kirkwood.learnx.model.JobListing;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jobListings")
public class JobListingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<JobListing> jobListings = new ArrayList<>();
        int limit = 5;
        int offset = 0;
        try{
            jobListings = JobListingDAO.getAll(limit,offset,"", "");
        }
        catch(Exception ex){
            throw ex;
        }
        req.setAttribute("jobListings", jobListings);
        req.getRequestDispatcher("WEB-INF/learnx/job-listings.jsp").forward(req, resp);
    }
}
