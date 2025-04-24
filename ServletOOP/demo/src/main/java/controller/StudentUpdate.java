package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

@WebServlet("/api/students/update")
public class StudentUpdate extends HttpServlet{
    private StudentService serviceStudent = new StudentService();

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("ID"));
        String column = req.getParameter("Column");
        String value = req.getParameter("Value");
        try {
            serviceStudent.updateStudent(id, column, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
        resp.sendRedirect("/demo");
    }
}