package repository;

import model.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findAll();

    Course findById(long id);

    List<Course> findByStudentId(long id);

    List<Course> findByTeacherId(long id);

    Course findByName(String name);

    boolean saveCourse(Course course);
}
