package com.shirley.demo.day28;


import com.shirley.data_access.UserDAO;
import com.shirley.demo.day25.User;
import com.shirley.project.utilities.PasswordUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import static com.shirley.data_access.UserDAO.UpdateUser;

@WebServlet(name="loginServlet", value="/login")
public class LoginServlet extends HttpServlet {

    private static Map<String, String> results = new HashMap<>();
    private static int attempts = 5;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/day28/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("inputEmail1");
        String password = req.getParameter("inputPassword1");
        String[] rememberMe = req.getParameterValues("rememberCheck1");

        results.clear();
        results.put("email", email);
        results.put("password", password);
        if(rememberMe!= null && rememberMe[0].equals("true")) {
            results.put("rememberMe", "true");
        }  else {
            results.put("rememberMe", "");
        }

        try{
            User userFromDatabase = UserDAO.get(email);

            if(userFromDatabase == null){
                //email not found
                results.put("loginFail", "No user found with that email and password combination.");
            }
            else{
                //email is found
                if(!PasswordUtility.checkpw(password, String.valueOf(userFromDatabase.getPassword()))){
                    //passwords don't match
                    attempts -= 1;
                    if(attempts > 0) {
                        results.put("loginFail", "Password Incorrect." + attempts + " Attempts remaining.");
                    } else{
                       userFromDatabase.setStatus("locked");
                       UpdateUser(userFromDatabase);
                        results.put("loginFail", "User account needs to reset password");
                    }
                }
                else{
                    //passwords match
                    attempts = 5;
                    results.put("loginSuccess", "Welcome back!");
                }
            }
        }catch(Exception e){
            results.put("loginFail", "Cannot log you in. Try again later");
        }

        req.setAttribute("results", results);
        req.getRequestDispatcher("WEB-INF/day28/login.jsp").forward(req, resp);
    }
}
