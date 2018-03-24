package repository;

import model.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findAll();

    Course findById(Long id);

    List<Course> findByTeacherId(Long id);

    Course findByName(String name);

    boolean saveCourse(Course course);
}
