package dao;

import model.Class;
import model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAllStudent();

    Student findByID(String id);

    List<Student> findByName(String name);

    String save(Student student);

    String update(Student student);

    void delete(String id);

    List<Class> findAllClass();

    List<String> findAllIDStudent();
}
