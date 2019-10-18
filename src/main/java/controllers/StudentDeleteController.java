package controllers;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentDeleteController", urlPatterns ="/delete-student" )
public class StudentDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("idsDeleteStud");
        String[] idsArr = ids.split(",");
        for (String id: idsArr){
            DBManager.deleteStudents(id);
        }
        resp.sendRedirect("/students");
    }
}
