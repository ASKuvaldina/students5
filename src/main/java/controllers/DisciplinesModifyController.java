package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplinesModifyController", urlPatterns = "/modify-discipline")
public class DisciplinesModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDisc = req.getParameter("idModifDisc");
        Discipline discipline = DBManager.getDisciplinesbyid(idDisc);
        req.setAttribute("discipline", discipline);
        req.getRequestDispatcher("/WEB-INF/jsp/modify-discipline.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newName = req.getParameter("nameDisc"); //modify-discipline
        String idDisc = req.getParameter("discId"); //modify-discipline
        DBManager.modifyDisciplines(idDisc,newName);
        resp.sendRedirect("/disciplines");
    }
}
