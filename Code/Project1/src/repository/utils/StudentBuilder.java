package repository.utils;

import model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBuilder {
    public static Student createStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setStudentId(rs.getLong("student_id"));
        student.setEmail(rs.getString("student_email"));
        student.setName(rs.getString("student_name"));
        student.setCNP(rs.getString("CNP"));
        student.setAddress(rs.getString("address"));
        student.setGroup(rs.getInt("group_1"));
        student.setPassword(rs.getString("password"));

        return student;
    }

    public static List<Student> createStudents(ResultSet rs) throws SQLException {
        List<Student> students = new ArrayList<Student>(100);
        while (rs.next()) {
            Student student = createStudent(rs);
            students.add(student);
        }
        return students;
    }
}
