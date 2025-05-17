package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

@WebServlet("/api/students/*")
public class StudentPrint extends HttpServlet{
    private StudentService serviceStudent = new StudentService();

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("ID"));
        Student student = null;
        try {
            student = serviceStudent.printStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");

        if (student != null) {
            out.println("<h2>Student Details</h2>");
            out.println("<p>ID: " + student.getId() + "</p>");
            out.println("<p>Name: " + student.getName() + "</p>");
            out.println("<p>Age: " + student.getAge() + "</p>");
            out.println("<p>GPA: " + student.getGpa() + "</p>");
        } else {
            out.println("<p>Student not found.</p>");
        }
        out.println("</body></html>");
    }
}