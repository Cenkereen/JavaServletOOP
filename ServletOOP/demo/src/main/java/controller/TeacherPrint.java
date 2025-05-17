package controller;
import service.TeacherService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import entity.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/api/teachers/*")
public class TeacherPrint extends HttpServlet{
    private TeacherService serviceTeacher = new TeacherService();


    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("ID"));
        Teacher teacher = null;
        try {
            teacher = serviceTeacher.printTeacher(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");

        if (teacher != null) {
            out.println("<h2>Teacher Details</h2>");
            out.println("<p>ID: " + teacher.getId() + "</p>");
            out.println("<p>Name: " + teacher.getName() + "</p>");
            out.println("<p>Course Name: " + teacher.getClassName() + "</p>");
            out.println("<p>Age: " + teacher.getAge() + "</p>");
        } else {
            out.println("<p>Teacher not found.</p>");
        }

        out.println("</body></html>"); 
    }
}
