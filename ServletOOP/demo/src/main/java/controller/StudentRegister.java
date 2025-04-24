package controller;
import dto.Student;
import service.StudentService;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/api/students/register")
public class StudentRegister extends HttpServlet{
    private StudentService serviceStudent = new StudentService();


    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("ID"));
            String name = req.getParameter("Name");
            Float GPA = Float.parseFloat(req.getParameter("GPA"));
            int age = Integer.parseInt(req.getParameter("Age"));
            
            Student student = new Student(id, name, GPA, age);

            try {
                serviceStudent.registerStudent(student);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            resp.sendRedirect("/demo");
	}    
}

