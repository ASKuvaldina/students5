package controllers;

import database.DBManager;

import entity.Mark;
import entity.Semestr;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentProgressController", urlPatterns = "/progress-student")
public class StudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStud = req.getParameter("idProgStud");
        Student student = DBManager.getStudentbyid(idStud);
        List<Semestr> semestrs = DBManager.getAllActiveSemestrs();
        Semestr selectedSemestr = semestrs.get(0);
        List<Mark> marks = DBManager.getMarksByStudentSemestr(idStud,selectedSemestr.getId());
        req.setAttribute("marks",marks);
        req.setAttribute("student",student);
        req.setAttribute("semestrs",semestrs);
        req.setAttribute("selectedSemestr",selectedSemestr);


        req.getRequestDispatcher("/WEB-INF/jsp/studentProgress.jsp").forward(req,resp);

    }
}
