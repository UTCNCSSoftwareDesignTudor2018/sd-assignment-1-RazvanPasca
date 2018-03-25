package repository.utils;

import model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherBuilder {
    public static Teacher createTeacher(ResultSet rs) throws SQLException {

        Teacher teacher = new Teacher();
        teacher.setEmail(rs.getString("teacher_email"));
        teacher.setName(rs.getString("teacher_name"));
        teacher.setPassword(rs.getString("password"));
        teacher.setTeacherId(rs.getLong("teacher_id"));
        return teacher;
    }

    public static List<Teacher> createTeachers(ResultSet rs) throws SQLException {
        List<Teacher> teachers = new ArrayList<Teacher>(100);
        while (rs.next()) {
            Teacher teacher = createTeacher(rs);
            teachers.add(teacher);
        }
        return teachers;
    }
}
