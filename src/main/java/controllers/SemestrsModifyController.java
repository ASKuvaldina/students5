package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Semestr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "SemestrsModifyController", urlPatterns ="/modify-semestrs" )
public class SemestrsModifyController extends HttpServlet {
    private int idSem = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int TermId = Integer.parseInt(req.getParameter("idModifSem"));
        idSem = TermId;
        List<Discipline> disciplinesInSemestr = DBManager.getAllActiveDisciplines();
        req.setAttribute("disciplinesInSemestr", disciplinesInSemestr);
        req.getRequestDispatcher("/WEB-INF/jsp/modify-semestrs.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String newDuration = req.getParameter("duration");
        String ids = (req.getParameter("selectedDiscId"));
//        String[] idsArr = ids.split(",");
        int[] idsArr = Arrays.stream(ids.split(",")).mapToInt(Integer::parseInt).toArray();
        DBManager.modifySemestr(idSem,idsArr);

        resp.sendRedirect("/semestrs");
    }
}
