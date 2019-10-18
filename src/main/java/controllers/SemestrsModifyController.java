package controllers;

import database.DBManager;
import entity.Semestr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SemestrsModifyController", urlPatterns ="/modify-semestrs" )
public class SemestrsModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String idSem = req.getParameter("idModifSem");
//        Semestr semestr = DBManager.getSemestrbyid(idSem);
//        req.setAttribute("semestr", semestr);
        req.getRequestDispatcher("/WEB-INF/jsp/modify-semestrs.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newId = req.getParameter("idSem"); //modify-student
        String newDuration = req.getParameter("duration");
        String ids = req.getParameter("selectDiscipline");
        String[] idsArr = ids.split(",");
        for (String id: idsArr){
            DBManager.modifySelectDiscipline(newId,id);
        }
        DBManager.modifySemestr(newId,newDuration);

        resp.sendRedirect("/semestrs");
    }
}
