package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DisciplinesInSemestrController", urlPatterns = "/getDiscinSem")
public class DisciplinesInSemestrController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idSem = req.getParameter("idSem");
        List<Discipline> disciplinesInSemestr = DBManager.getDisciplinesInSemestr(idSem);
        req.setAttribute("disciplinesInSemestr",disciplinesInSemestr);
        resp.sendRedirect("/semestrs");
    }
}
