package repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.Teacher;

public class TeacherRepository {
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

    public void addTeacher(Teacher teacher) throws SQLException{
        Connection conn = getConnection();
        PreparedStatement pS = conn.prepareStatement("INSERT INTO TEACHERS VALUES (?, ?, ?, ?);");

        pS.setInt(1, teacher.getId());
        pS.setString(2, teacher.getName());
        pS.setString(3, teacher.getClassName());
        pS.setInt(4, teacher.getAge());
        pS.executeUpdate();

        pS.close();
        conn.close();
    }

    public List<Teacher> getAllTeachers() throws SQLException{
        Connection conn = getConnection();
        List<Teacher> teachers = new ArrayList<>();

        Statement stmt = conn.createStatement();
        ResultSet rS = stmt.executeQuery("SELECT * FROM TEACHERS;");
        
        while (rS.next()) {
            int id = rS.getInt("ID");
            String name = rS.getString("Name");
            String className = rS.getString("ClassName");
            int age = rS.getInt("Age");

            Teacher teacher = new Teacher(id, name, className, age);
            teachers.add(teacher);
        }

        rS.close();
        conn.close();

        return teachers;
    }

    public Teacher getTeacher(int id_) throws SQLException{
        Connection conn = getConnection();

        PreparedStatement pS = conn.prepareStatement("SELECT * FROM TEACHERS WHERE ID = ?;");
        pS.setInt(1, id_);

        ResultSet rS = pS.executeQuery();
        Teacher teacher = null;

        if (rS.next()) {
            int id = rS.getInt("ID");
            String name = rS.getString("Name");
            String className = rS.getString("ClassName");
            int age = rS.getInt("Age");

            teacher = new Teacher(id, name, className, age);
        }

        rS.close();
        pS.close();
        conn.close();

        return teacher;
        }

    public void delTeacher(int id) throws SQLException{
        Connection conn = getConnection();
        PreparedStatement pS = conn.prepareStatement("DELETE FROM TEACHERS WHERE ID = ?;");

        pS.setInt(1, id);
        pS.executeUpdate();

        pS.close();
        conn.close();
    }

    public void upTeacher(int id, String column, String value) throws SQLException{
        Connection conn = getConnection();
        PreparedStatement pS = conn.prepareStatement("UPDATE TEACHERS SET " + column + " = ? WHERE ID = ?;");

        pS.setString(1, value);
        pS.setInt(2, id);
        pS.executeUpdate();

        pS.close();
        conn.close();
    }
}
