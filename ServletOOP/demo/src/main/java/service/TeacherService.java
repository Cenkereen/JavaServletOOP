package service;
import java.sql.SQLException;
import java.util.List;

import dao.TeacherRepository;
import dto.Teacher;

public class TeacherService {
    private TeacherRepository repository = new TeacherRepository();

    public void registerTeacher(Teacher teacher) throws SQLException {
        repository.addTeacher(teacher);
    }

    public List<Teacher> printAll() throws SQLException{
        return repository.getAllTeachers();
    }

    public Teacher printTeacher(int id) throws SQLException{
        return repository.getTeacher(id);
    }

    public void deleteTeacher(int id) throws SQLException{
        repository.delTeacher(id);
    }

    public void updateTeacher(int id, String column, String value) throws SQLException {
        repository.upTeacher(id, column, value);
    }
}
