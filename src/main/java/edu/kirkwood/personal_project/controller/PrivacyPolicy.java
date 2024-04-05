package edu.kirkwood.personal_project.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/privacy_policy")
public class PrivacyPolicy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageTitle", "Privacy Policy");
        req.getRequestDispatcher("WEB-INF/personal_project/privacy_policy.jsp").forward(req, resp);
    }
}
