package repository.utils;

import model.Grade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeBuilder {
    public static Grade createGrade(ResultSet rs) throws SQLException {

        Grade grade = new Grade();
        grade.setCourseId(rs.getLong("course_id"));
        grade.setGrade(rs.getInt("grade"));
        grade.setStudentId(rs.getLong("student_id"));
        grade.setDate(rs.getDate("date"));
        return grade;
    }

    public static List<Grade> createGrades(ResultSet rs) throws SQLException {
        List<Grade> exams = new ArrayList<Grade>(100);
        while (rs.next()) {
            Grade grade = createGrade(rs);
            exams.add(grade);
        }
        return exams;
    }
}
