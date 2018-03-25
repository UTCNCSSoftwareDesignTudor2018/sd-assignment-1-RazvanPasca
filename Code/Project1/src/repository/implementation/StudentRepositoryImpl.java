package repository.implementation;

import connection.DatabaseConnection;
import model.Student;
import repository.StudentRepository;
import repository.utils.StudentBuilder;

import java.sql.*;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public List<Student> findAll() {
        Connection connection = DatabaseConnection.getConnection();
        List<Student> students = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();
            students = StudentBuilder.createStudents(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student findById(long id) {
        Connection connection = DatabaseConnection.getConnection();
        Student student = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM students WHERE student_id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                student = StudentBuilder.createStudent(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        Connection connection = DatabaseConnection.getConnection();
        Student student = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM students WHERE student_email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                student = StudentBuilder.createStudent(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findByName(String name) {
        Connection connection = DatabaseConnection.getConnection();
        List<Student> students = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM students WHERE student_name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            students = StudentBuilder.createStudents(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean save(Student student) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO students " +
                            "(student_id,student_email,student_name,CNP,password,address,group_1) VALUES (?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, 0);
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getName());
            ps.setString(4, student.getCNP());
            ps.setString(5, student.getPassword());
            ps.setString(6, student.getAddress());
            ps.setLong(7, student.getGroup());
            return ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE students SET student_email=?,student_name=?," +
                            "password=?,address=?,group_1=? WHERE student_id=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getEmail());
            ps.setString(2, student.getName());
            ps.setString(3, student.getPassword());
            ps.setString(4, student.getAddress());
            ps.setInt(5, student.getGroup());
            ps.setLong(6, student.getStudentId());
            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM students WHERE student_id = ?");
            ps.setLong(1, id);
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
