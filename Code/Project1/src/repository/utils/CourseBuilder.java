package repository.utils;

import model.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseBuilder {
    public static Course createCourse(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setCourseId(rs.getLong("course_id"));
        course.setName(rs.getString("name"));
        course.setTeacherId(rs.getLong("teacher_id"));
        return course;

    }

    public static List<Course> createCourses(ResultSet rs) throws SQLException {
        List<Course> courses = new ArrayList<Course>(100);
        while (rs.next()) {
            Course teacher = createCourse(rs);
            courses.add(teacher);
        }
        return courses;
    }
}
