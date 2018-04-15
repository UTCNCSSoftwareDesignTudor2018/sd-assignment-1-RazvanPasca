package business.implementation;

import business.ContextHolder;
import business.StudentBusiness;
import model.*;
import repository.CourseRepository;
import repository.EnrolmentRepository;
import repository.GradeRepository;
import repository.StudentRepository;
import repository.implementation.CourseRepositoryImpl;
import repository.implementation.EnrolmentRepositoryImpl;
import repository.implementation.GradeRepositoryImpl;
import repository.implementation.StudentRepositoryImpl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class StudentBusinessImpl implements StudentBusiness {
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;
    private final ContextHolder contextHolder;
    private final CourseRepository courseRepository;
    private final EnrolmentRepository enrolmentRepository;

    public StudentBusinessImpl(ContextHolder contextHolder) {
        this.studentRepository = new StudentRepositoryImpl();
        this.gradeRepository = new GradeRepositoryImpl();
        this.contextHolder = contextHolder;
        this.courseRepository = new CourseRepositoryImpl();
        this.enrolmentRepository = new EnrolmentRepositoryImpl();
    }

    public boolean login(String email, String password) {
        Student student = studentRepository.findByEmail(email);
        if (student != null) {
            if (student.getPassword().equals(password)) {
                ContextHolder.setCurrentUser(student);
                return true;
            }
        }
        return false;
    }

    public boolean updateProfile(Student student) {
        return studentRepository.update(student);
    }

    public User viewProfile() {
        return contextHolder.getCurrentUser();
    }

    public Map<Course, Teacher> viewCourses() {
        return courseRepository.findAll();
    }


    public List<RegisterEntry> viewGrades() {
        Student student = (Student) contextHolder.getCurrentUser();
        System.out.println(student);
        return gradeRepository.findByStudentId(student.getStudentId());

    }

    @Override
    public boolean enroll(long courseId) {
        Student student = (Student) ContextHolder.getCurrentUser();
        Enrolment enrolment = new Enrolment(student.getStudentId(),
                courseId, false, new Date(System.currentTimeMillis()));
        return enrolmentRepository.saveEnrolment(enrolment);
    }
}
