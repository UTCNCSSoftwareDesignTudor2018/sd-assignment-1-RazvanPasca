package repository.utils;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterEntryBuilder {
    public static RegisterEntry createRegisterEntry(ResultSet rs) throws SQLException {
        Student student = StudentBuilder.createStudent(rs);
        Course course = CourseBuilder.createCourse(rs);
        Grade grade = GradeBuilder.createGrade(rs);
        Teacher teacher = TeacherBuilder.createTeacher(rs);
        RegisterEntry registerEntry = new RegisterEntry(student, course, teacher, grade);
        return registerEntry;
    }
}
