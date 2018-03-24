package repository.utils;

import model.Exam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamBuilder {
    public static Exam createExam(ResultSet rs) throws SQLException {

        Exam exam = new Exam();
        exam.setCourseId(rs.getLong("course_id"));
        exam.setExamDate(rs.getDate("date"));
        return exam;
    }

    public static List<Exam> createExams(ResultSet rs) throws SQLException {
        List<Exam> exams = new ArrayList<Exam>(100);
        while (rs.next()) {
            Exam exam = createExam(rs);
            exams.add(exam);
        }
        return exams;
    }
}
