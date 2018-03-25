package repository.implementation;

import connection.DatabaseConnection;
import model.Course;
import model.Teacher;
import repository.CourseRepository;
import repository.utils.CourseBuilder;
import repository.utils.TeacherBuilder;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRepositoryImpl implements CourseRepository {
    @Override
    public Map<Course, Teacher> findAll() {
        Connection connection = DatabaseConnection.getConnection();
        Map<Course, Teacher> courses = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT courses.*, teachers.* FROM courses JOIN " +
                    "teachers ON courses.teacher_id = teachers.teacher_id");
            ResultSet rs = ps.executeQuery();
            courses = this.createMap(rs);
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
    public Map<Course, Teacher> findByStudentId(long id) {
        Connection connection = DatabaseConnection.getConnection();
        Map<Course, Teacher> courses = null;
        try {
            PreparedStatement ps = connection.prepareStatement(new StringBuilder().append("SELECT courses.*,teachers.* FROM ").
                    append("enrolments JOIN courses ON courses.course_id = enrolments.course_id ").
                    append(" JOIN teachers ON courses.teacher_id = teachers.teacher_id ").
                    append(" WHERE enrolments.student_id = ?").toString());
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            courses = this.createMap(rs);
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
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM courses WHERE course_name = ?");
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
                    "(course_id, course_name,teacher_id) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, 0);
            ps.setString(2, course.getName());
            ps.setLong(3, course.getTeacherId());
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    private Map<Course, Teacher> createMap(ResultSet resultSet) throws SQLException {
        Map<Course, Teacher> courses = new HashMap<>(10);
        while (resultSet.next()) {
            Course course = CourseBuilder.createCourse(resultSet);
            Teacher teacher = TeacherBuilder.createTeacher(resultSet);
            courses.put(course, teacher);
        }
        return courses;
    }
}

