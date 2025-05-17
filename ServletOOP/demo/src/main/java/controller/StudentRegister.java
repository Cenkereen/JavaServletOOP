package controller;
import service.StudentService;

import java.io.IOException;
import java.sql.SQLException;

import dto.StudentDto;
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
            
            StudentDto studentDTO = new StudentDto(id, name, GPA, age);

            try {
                serviceStudent.registerStudent(studentDTO);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            resp.sendRedirect("/demo");
	}    
}

