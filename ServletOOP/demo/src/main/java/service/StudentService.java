package service;
import java.sql.SQLException;
import java.util.List;

import dto.StudentDto;
import entity.Student;
import repository.StudentRepository;

public class StudentService {
    private StudentRepository repository = new StudentRepository();

    public void registerStudent(StudentDto dto) throws SQLException {
        Student student = new Student(dto.getId(), dto.getName(), dto.getGpa(), dto.getAge());
        repository.addStudent(student);
    }

    public List<Student> printAll() throws SQLException{
        return repository.getAllStudents();
    }

    public Student printStudent(int id) throws SQLException{
        return repository.getStudent(id);
    }

    public void deleteStudent(int id) throws SQLException{
        repository.delStudent(id);
    }

    public void updateStudent(int id, String column, String value) throws SQLException {
        repository.upStudent(id, column, value);
    }
}
