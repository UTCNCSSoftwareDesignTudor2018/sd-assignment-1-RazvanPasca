package repository.implementation;

import connection.DatabaseConnection;
import model.Grade;
import repository.GradeRepository;
import repository.utils.GradeBuilder;

import java.sql.*;
import java.util.List;

public class GradeRepositoryImpl implements GradeRepository {
    @Override
    public List<Grade> findAll() {
        Connection connection = DatabaseConnection.getConnection();
        List<Grade> grades = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM grades");
            ResultSet rs = ps.executeQuery();
            grades = GradeBuilder.createGrades(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    @Override
    public List<Grade> findByStudentId(long id) {
        Connection connection = DatabaseConnection.getConnection();
        List<Grade> grades = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM grades WHERE student_id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            grades = GradeBuilder.createGrades(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    @Override
    public List<Grade> findByCourseId(long id) {
        Connection connection = DatabaseConnection.getConnection();
        List<Grade> grades = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM grades WHERE course_id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            grades = GradeBuilder.createGrades(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    @Override
    public boolean saveGrade(Grade grade) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO grades " +
                    "(student_id, course_id,grade,date) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, grade.getStudentId());
            ps.setLong(2, grade.getCourseId());
            ps.setLong(3, grade.getGrade());
            ps.setDate(4, grade.getDate());
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateGrade(Grade grade) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE grades SET student_id=?,course_id=?,grade=?,date = ? WHERE student_id=? AND course_id = ?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, grade.getStudentId());
            ps.setLong(2, grade.getCourseId());
            ps.setLong(3, grade.getGrade());
            ps.setDate(4, grade.getDate());
            ps.setLong(5, grade.getStudentId());
            ps.setLong(6, grade.getCourseId());
            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
