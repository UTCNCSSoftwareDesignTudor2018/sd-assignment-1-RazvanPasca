package repository;

import model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();

    Student findById(Long id);

    Student findByEmail(String email);

    List<Student> findByName(String name);

    boolean save(Student student);

    boolean update(Student student);

    boolean delete(Long id);
}
