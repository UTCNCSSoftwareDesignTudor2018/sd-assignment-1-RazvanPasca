package business;

import model.*;

import java.util.List;

public interface TeacherBusiness {

    boolean login(String email,String password);

    boolean createStudent(Student student);

    List<Student> viewStudents();

    User viewProfile();

    boolean updateStudent(Student student);

    boolean deleteStudent(Student student);

    boolean generateStudentReport(Student student);

    List<RegisterEntry> getEnrolledStudents();

    boolean addGrade(Grade grade);

    boolean updateGrade(Grade grade);

    boolean updateProfile(Teacher teacher);
}
