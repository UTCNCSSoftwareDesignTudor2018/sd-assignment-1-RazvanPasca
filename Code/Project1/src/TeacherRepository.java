package repository;

import model.Teacher;

import java.util.List;

public interface TeacherRepository {
    List<Teacher> findAll();

    Teacher findById(Long id);

    List<Teacher> findByName(String email);

    Teacher findByEmail(String email);

    boolean saveTeacher(Teacher teacher);
}

