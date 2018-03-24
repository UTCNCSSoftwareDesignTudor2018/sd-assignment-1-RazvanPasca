package repository.implementation;

import connection.DatabaseConnection;
import model.Teacher;
import repository.TeacherRepository;
import repository.utils.TeacherBuilder;

import java.sql.*;
import java.util.List;

public class TeacherRepositoryImpl implements TeacherRepository {

    @Override
    public List<Teacher> findAll() {
        Connection connection = DatabaseConnection.getConnection();
        List<Teacher> teachers = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM teachers");
            ResultSet rs = ps.executeQuery();
            teachers = TeacherBuilder.createTeachers(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    @Override
    public Teacher findById(Long id) {
        Connection connection = DatabaseConnection.getConnection();
        Teacher teacher = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM teachers WHERE teacher_id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                teacher = TeacherBuilder.createTeacher(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public List<Teacher> findByName(String name) {
        Connection connection = DatabaseConnection.getConnection();
        List<Teacher> teachers = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM teachers WHERE name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            teachers = TeacherBuilder.createTeachers(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    @Override
    public Teacher findByEmail(String email) {
        Connection connection = DatabaseConnection.getConnection();
        Teacher teacher = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM teachers WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                teacher = TeacherBuilder.createTeacher(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public boolean saveTeacher(Teacher teacher) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO teachers " +
                    "(teacher_id, name, email, password) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, 0);
            ps.setString(2, teacher.getName());
            ps.setString(3, teacher.getEmail());
            ps.setString(4, teacher.getPassword());
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
