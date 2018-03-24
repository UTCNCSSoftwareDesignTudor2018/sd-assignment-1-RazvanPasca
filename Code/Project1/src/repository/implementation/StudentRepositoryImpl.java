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
    public Student findById(Long id) {
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
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM students WHERE email = ?");
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
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM students WHERE name = ?");
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
                            "(student_id,email,name,password,address,groupp) VALUES (?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, 0);
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getName());
            ps.setString(4, student.getPassword());
            ps.setString(5, student.getAddress());
            ps.setLong(6, student.getGroup());
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
            PreparedStatement ps = connection.prepareStatement("UPDATE students SET email=?,name=?,password=?,address=?,groupp=? WHERE student_id=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, 0);
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getName());
            ps.setString(4, student.getPassword());
            ps.setString(5, student.getAddress());
            ps.setLong(6, student.getGroup());
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
    public boolean delete(Long id) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM students WHERE student_id = id");
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
