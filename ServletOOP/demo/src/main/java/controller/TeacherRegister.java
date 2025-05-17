package controller;
import service.TeacherService;

import java.io.IOException;
import java.sql.SQLException;

import dto.TeacherDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/api/teachers/register")
public class TeacherRegister extends HttpServlet{
    private TeacherService serviceTeacher = new TeacherService();


    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("ID"));
        String name = req.getParameter("Name");
        String className = req.getParameter("className");
        int age = Integer.parseInt(req.getParameter("Age"));
        
        TeacherDto teacher = new TeacherDto(id, name, className, age);

        try {
            serviceTeacher.registerTeacher(teacher);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        resp.sendRedirect("/demo");
    }
}