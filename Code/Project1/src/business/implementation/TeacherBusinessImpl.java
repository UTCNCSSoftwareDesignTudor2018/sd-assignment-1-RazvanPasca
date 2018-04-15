package business.implementation;

import business.ContextHolder;
import business.TeacherBusiness;
import business.utils.ReportWriter;
import model.*;
import repository.GradeRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import repository.implementation.GradeRepositoryImpl;
import repository.implementation.StudentRepositoryImpl;
import repository.implementation.TeacherRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class TeacherBusinessImpl implements TeacherBusiness {

    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private GradeRepository gradeRepository;
    private ContextHolder contextHolder;
    private ReportWriter reportWriter;

    public TeacherBusinessImpl(ContextHolder contextHolder) {
        this.teacherRepository = new TeacherRepositoryImpl();
        this.studentRepository = new StudentRepositoryImpl();
        this.gradeRepository = new GradeRepositoryImpl();
        this.reportWriter = new ReportWriter();
    }


    @Override
    public boolean login(String email, String password) {
        Teacher teacher = teacherRepository.findByEmail(email);
        if (teacher != null) {
            if (teacher.getPassword().equals(password)) {
                ContextHolder.setCurrentUser(teacher);
                return true;
            } else {
                System.out.println("invalid password");
            }
        } else {
            System.out.println("user with email " + email + " not found");
        }
        return false;
    }

    @Override
    public boolean createStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public List<Student> viewStudents() {
        return studentRepository.findAll();
    }

    @Override
    public User viewProfile() {
        return contextHolder.getCurrentUser();
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public boolean deleteStudent(Student student) {
        System.out.println(student.getStudentId());
        return studentRepository.delete(student.getStudentId());
    }

    @Override
    public boolean generateStudentReport(Student student) {
        reportWriter.setFileName(student.getName().toUpperCase() + "_" + "REPORT_FILE.txt");
        List<RegisterEntry> registerEntries = gradeRepository.findByStudentId(student.getStudentId());
        if (registerEntries == null)
            return false;
        else {
            try {
                reportWriter.writeReport(registerEntries);
                return true;
            } catch (IOException e) {
                return false;
            } finally {
                try {
                    reportWriter.closeConnections();
                } catch (IOException e) {
                    return false;
                }
            }
        }
    }

    @Override
    public List<RegisterEntry> getEnrolledStudents() {
        Teacher teacher = (Teacher) ContextHolder.getCurrentUser();
        return gradeRepository.findByTeacherId(teacher.getTeacherId());
    }

    @Override
    public boolean addGrade(Grade grade) {
        return gradeRepository.saveGrade(grade);
    }

    @Override
    public boolean updateGrade(Grade grade) {
        return gradeRepository.updateGrade(grade);
    }

    @Override
    public boolean updateProfile(Teacher teacher) {
        return teacherRepository.updateTeacher(teacher);
    }
}
