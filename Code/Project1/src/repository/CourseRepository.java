package repository;

import model.Course;
import model.Teacher;

import java.util.List;
import java.util.Map;

public interface CourseRepository {
    List<Course> findAll();

    Course findById(long id);

    Map<Course, Teacher> findByStudentId(long id);

    List<Course> findByTeacherId(long id);

    Course findByName(String name);

    boolean saveCourse(Course course);

}
