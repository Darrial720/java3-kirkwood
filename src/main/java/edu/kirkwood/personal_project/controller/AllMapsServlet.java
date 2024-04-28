package edu.kirkwood.personal_project.controller;

import edu.kirkwood.personal_project.data.MapDAO;
import edu.kirkwood.personal_project.model.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/all-maps")
public class AllMapsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map> maps = MapDAO.getALL();
        req.setAttribute("maps", maps);
        req.setAttribute("pageTitle", "Maps");
        req.getRequestDispatcher("WEB-INF/personal_project/maps.jsp").forward(req, resp);
    }
}
