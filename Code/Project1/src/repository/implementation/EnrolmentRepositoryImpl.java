package repository.implementation;

import connection.DatabaseConnection;
import model.Enrolment;
import repository.EnrolmentRepository;
import repository.utils.EnrolmentBuilder;

import java.sql.*;
import java.util.List;

public class EnrolmentRepositoryImpl implements EnrolmentRepository {

    @Override
    public List<Enrolment> findAll() {
        Connection connection = DatabaseConnection.getConnection();
        List<Enrolment> enrolments = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM enrolments");
            ResultSet rs = ps.executeQuery();
            enrolments = EnrolmentBuilder.createEnrolments(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrolments;
    }

    @Override
    public List<Enrolment> findByStudentId(long id) {
        Connection connection = DatabaseConnection.getConnection();
        List<Enrolment> enrolments = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM enrolments WHERE student_id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            enrolments = EnrolmentBuilder.createEnrolments(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrolments;
    }

    @Override
    public List<Enrolment> findByCourseId(long id) {
        Connection connection = DatabaseConnection.getConnection();
        List<Enrolment> enrolments = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM enrolments WHERE course_id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            enrolments = EnrolmentBuilder.createEnrolments(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrolments;
    }

    @Override
    public List<Enrolment> findByStatus(Boolean status) {
        Connection connection = DatabaseConnection.getConnection();
        List<Enrolment> enrolments = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM enrolments WHERE status = ?");
            ps.setBoolean(1, status);
            ResultSet rs = ps.executeQuery();
            enrolments = EnrolmentBuilder.createEnrolments(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrolments;
    }

    @Override
    public List<Enrolment> findByDate(Date date) {
        Connection connection = DatabaseConnection.getConnection();
        List<Enrolment> enrolments = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM enrolments WHERE requeste_date = ?");
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();
            enrolments = EnrolmentBuilder.createEnrolments(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrolments;
    }

    @Override
    public boolean saveEnrolment(Enrolment enrolment) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO enrolments " +
                    "(student_id, course_id,request_date,status) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, enrolment.getStudentId());
            ps.setLong(2, enrolment.getCourseId());
            ps.setDate(3, enrolment.getRequestDate());
            ps.setBoolean(4, enrolment.getStatus());
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Duplicate key when adding new enrolment, student is already enrolled");
        }
        return false;
    }

    @Override
    public boolean updateEnrolment(Enrolment enrolment) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE enrolments SET student_id=?,course_id=?,requeste_date=?,status=? WHERE student_id=? AND course_id = ?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, enrolment.getStudentId());
            ps.setLong(2, enrolment.getCourseId());
            ps.setDate(3, enrolment.getRequestDate());
            ps.setBoolean(4, enrolment.getStatus());
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
