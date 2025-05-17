package controller;
import service.TeacherService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import entity.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/api/teachers")
public class TeacherPrintAll extends HttpServlet{
    private TeacherService serviceTeacher = new TeacherService();


    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        List<Teacher> teacher = null;
        try {
            teacher = serviceTeacher.printAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println("<html><body>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Course Name</th><th>Age</th></tr>");

        for (Teacher s : teacher) {
            out.println("<tr>");
            out.println("<td>" + s.getId() + "</td>");
            out.println("<td>" + s.getName() + "</td>");
            out.println("<td>" + s.getClassName() + "</td>");
            out.println("<td>" + s.getAge() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
	}    
}
