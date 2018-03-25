package repository.implementation;

import connection.DatabaseConnection;
import model.Course;
import repository.CourseRepository;
import repository.utils.CourseBuilder;

import java.sql.*;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
    @Override
    public List<Course> findAll() {
        Connection connection = DatabaseConnection.getConnection();
        List<Course> courses = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM courses");
            ResultSet rs = ps.executeQuery();
            courses = CourseBuilder.createCourses(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public Course findById(long id) {
        Connection connection = DatabaseConnection.getConnection();
        Course course = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM courses WHERE course_id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                course = CourseBuilder.createCourse(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public List<Course> findByStudentId(long id) {
        Connection connection = DatabaseConnection.getConnection();
        List<Course> courses = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM courses WHERE student_id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            courses = CourseBuilder.createCourses(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public List<Course> findByTeacherId(long id) {
        Connection connection = DatabaseConnection.getConnection();
        List<Course> courses = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM courses WHERE teacher_id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            courses = CourseBuilder.createCourses(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public Course findByName(String name) {
        Connection connection = DatabaseConnection.getConnection();
        Course course = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM courses WHERE name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                course = CourseBuilder.createCourse(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public boolean saveCourse(Course course) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO courses " +
                    "(course_id, name,teacher_id) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, 0);
            ps.setString(2, course.getName());
            ps.setLong(3, course.getTeacherId());
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}

