package controllers;

import database.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentsModifyController", urlPatterns = "/modify-student")
public class StudentsModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStud = req.getParameter("idModifStud");
        Student student = DBManager.getStudentbyid(idStud);
        req.setAttribute("student", student);
        req.getRequestDispatcher("/WEB-INF/jsp/modify-student.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newId = req.getParameter("idStud"); //modify-student
        String newSurname = req.getParameter("surname");
        String newName = req.getParameter("name");
        String newGroup = req.getParameter("group");
        String newDate = req.getParameter("date");
        DBManager.modifyStudent(newId,newSurname,newName,newGroup,newDate);
        resp.sendRedirect("/students");
    }
}
