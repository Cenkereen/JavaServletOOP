package controller;
import service.StudentService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/api/students")
public class StudentPrintAll extends HttpServlet{
    private StudentService serviceStudent = new StudentService();


    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        List<Student> students = null;
        try {
            students = serviceStudent.printAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("<html><body>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>GPA</th></tr>");

        for (Student s : students) {
            out.println("<tr>");
            out.println("<td>" + s.getId() + "</td>");
            out.println("<td>" + s.getName() + "</td>");
            out.println("<td>" + s.getAge() + "</td>");
            out.println("<td>" + s.getGpa() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
	}    
}
