package service;
import java.sql.SQLException;
import java.util.List;

import dto.TeacherDto;
import entity.Teacher;
import repository.TeacherRepository;

public class TeacherService {
    private TeacherRepository repository = new TeacherRepository();

public void registerTeacher(TeacherDto dto) throws SQLException {
        Teacher teacher = new Teacher(dto.getId(), dto.getName(), dto.getClassName(), dto.getAge());
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
