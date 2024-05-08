package edu.kirkwood.learnx.controller;

import edu.kirkwood.learnx.data.JobApplicationDAO;
import edu.kirkwood.learnx.data.JobListingDAO;
import edu.kirkwood.learnx.model.JobApplication;
import edu.kirkwood.learnx.model.JobListing;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/application")
public class JobApplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> results = new HashMap<>();
        String jobID = req.getParameter("job_id");
        int id = Integer.parseInt(jobID);
        JobListing jobListing = JobListingDAO.getJobListingByID(id);
        if(jobListing != null){
            req.setAttribute("jobListing", jobListing);
        }
        else{
            results.put("jobFail", "Job not Found");
        }
        req.setAttribute("results", results);
        req.setAttribute("pageTitle", "Job Application");
        req.getRequestDispatcher("WEB-INF/learnx/job-applications.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> results = new HashMap<>();
        String jobID = req.getParameter("jobID");
        String firstName = req.getParameter("firstNameInput");
        String lastName = req.getParameter("lastNameInput");
        String email = req.getParameter("emailInput");
        String desiredSalary = req.getParameter("desiredSalaryInput");
        String earliestStartDate = req.getParameter("startDateInput");
        System.out.println(earliestStartDate);


        JobApplication jobApplication = new JobApplication();
        try{
            jobApplication.setJob_id(Integer.parseInt(jobID));
            jobApplication.setFirstName(firstName);
            jobApplication.setLastName(lastName);
            jobApplication.setEmail(email);
            jobApplication.setDesiredSalary(Integer.parseInt(desiredSalary));
            jobApplication.setEarliestStartDate(LocalDate.parse(earliestStartDate));

        }
        catch(Exception ex){
            results.put("ApplicationCreationFailure",ex.getMessage());
        }
        System.out.println(jobApplication);
        if(JobApplicationDAO.createJobApplication(jobApplication) == true){
            results.put("Success", "Application Successfully added");
        }
        else{
            results.put("applicationFail", "Application failed to submit");
        }



        req.setAttribute("results", results);
        req.setAttribute("pageTitle", "Job Application");
        req.getRequestDispatcher("WEB-INF/learnx/job-applications.jsp").forward(req, resp);
    }
}
