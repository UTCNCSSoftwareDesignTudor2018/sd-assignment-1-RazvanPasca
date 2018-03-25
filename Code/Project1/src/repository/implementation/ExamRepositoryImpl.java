package repository.implementation;

import connection.DatabaseConnection;
import model.Exam;
import repository.ExamRepository;
import repository.utils.ExamBuilder;

import java.sql.*;
import java.util.List;

public class ExamRepositoryImpl implements ExamRepository {
    @Override
    public List<Exam> findAll() {
        Connection connection = DatabaseConnection.getConnection();
        List<Exam> exams = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM exams");
            ResultSet rs = ps.executeQuery();
            exams = ExamBuilder.createExams(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }

    @Override
    public List<Exam> findByDate(Date date) {
        Connection connection = DatabaseConnection.getConnection();
        List<Exam> exams = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM exams WHERE date = ?");
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();
            exams = ExamBuilder.createExams(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }

    @Override
    public Exam findById(long id) {
        Connection connection = DatabaseConnection.getConnection();
        Exam exam = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM exams WHERE course_id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                exam = ExamBuilder.createExam(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exam;
    }

    @Override
    public boolean saveExam(Exam exam) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO exams " +
                    "(course_id, date) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, exam.getCourseId());
            ps.setDate(2, exam.getExamDate());
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
