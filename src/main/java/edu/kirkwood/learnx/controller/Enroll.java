package edu.kirkwood.learnx.controller;

import edu.kirkwood.learnx.data.CourseDAO;
import edu.kirkwood.learnx.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/enroll")
public class Enroll extends HttpServlet {
    private boolean isNumber(String s){
        try {
                Integer.parseInt(s);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId = req.getParameter("course");
        if(courseId == null || !isNumber(courseId)){
            resp.sendRedirect("courses");
            return;
        }
        int courseIdInt = Integer.parseInt(courseId);
        HttpSession session = req.getSession();
        User userFromSession = (User)session.getAttribute("activeUser");
        if(userFromSession == null || !userFromSession.getPrivileges().equals("student")){
            resp.sendRedirect("courses");
            return;
        }
        if(CourseDAO.enroll(userFromSession.getId(), courseIdInt)){
            session.setAttribute("FlashMessageSuccess", "You are enrolled!");
            resp.sendRedirect("student");
            return;
        }
        else{
            session.setAttribute("FlashMessageDanger", "Enrollment Failed. Try again later");
            resp.sendRedirect("courses");
            return;
        }

    }
}
