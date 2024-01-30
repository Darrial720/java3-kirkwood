package edu.kirkwood.demo;

import edu.kirkwood.shared.CommunicationService;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/email")
public class EmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/demos/email.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the parameters from the request object
        // Create a CommunicationService object, and call a method to send an email
        // Set the "success" attribute
        // Forward the request to the JSP
        String success = "email sent";
        String email = req.getParameter("email1");
        String subject = req.getParameter("subject");
        String message = req.getParameter("message");
        CommunicationService.sendEmail(email, subject, message);

        req.setAttribute("success", success);
        //req.setAttribute("pageTitle", "SUCCESS");
        req.getRequestDispatcher("WEB-INF/demos/email.jsp").forward(req, resp);
    }
}
