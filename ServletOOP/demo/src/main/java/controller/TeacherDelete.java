package controller;
import service.TeacherService;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/api/teachers/delete")
public class TeacherDelete extends HttpServlet{
    private TeacherService serviceTeacher = new TeacherService();


    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("ID"));
        try {
            serviceTeacher.deleteTeacher(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        resp.sendRedirect("/demo");
    }
}