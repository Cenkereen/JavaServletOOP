package repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.Student;

public class StudentRepository {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/demo";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345678";

    private Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
                return null;
	}

    public void addStudent(Student student) throws SQLException{
        Connection conn = getConnection();
        PreparedStatement pS = conn.prepareStatement("INSERT INTO INFO VALUES (?, ?, ?, ?);");

        pS.setInt(1, student.getId());
        pS.setString(2, student.getName());
        pS.setFloat(3, student.getGpa());
        pS.setInt(4, student.getAge());
        pS.executeUpdate();

        pS.close();
        conn.close();
    }

    public List<Student> getAllStudents() throws SQLException{
        Connection conn = getConnection();
        List<Student> students = new ArrayList<>();

        Statement stmt = conn.createStatement();
        ResultSet rS = stmt.executeQuery("SELECT * FROM INFO;");
        
         while (rS.next()) {
                int id = rS.getInt("ID");
                String name = rS.getString("Name");
                int age = rS.getInt("Age");
                float gpa = rS.getFloat("GPA");

                Student student = new Student(id, name, gpa, age);
                students.add(student);
            }
        rS.close();
        conn.close();
        return students;
    }

    public Student getStudent(int id_) throws SQLException{
        Connection conn = getConnection();

        PreparedStatement pS = conn.prepareStatement("SELECT * FROM INFO WHERE ID = ?;");
        pS.setInt(1, id_);

        ResultSet rS = pS.executeQuery();
        Student student = null;

        if (rS.next()) {
            int id = rS.getInt("ID");
            String name = rS.getString("Name");
            int age = rS.getInt("Age");
            float gpa = rS.getFloat("GPA");

            student = new Student(id, name, gpa, age);
        }

        rS.close();
        pS.close();
        conn.close();

        return student;
        }

    public void delStudent(int id) throws SQLException{
        Connection conn = getConnection();
        PreparedStatement pS = conn.prepareStatement("DELETE FROM INFO WHERE ID = ?;");

        pS.setInt(1, id);
        pS.executeUpdate();

        pS.close();
        conn.close();
    }

    public void upStudent(int id, String column, String value) throws SQLException{
        Connection conn = getConnection();
        PreparedStatement pS = conn.prepareStatement("UPDATE INFO SET " + column + " = ? WHERE ID = ?");

        pS.setString(1, value);
        pS.setInt(2, id);
        pS.executeUpdate();

        pS.close();
        conn.close();
    }
}
