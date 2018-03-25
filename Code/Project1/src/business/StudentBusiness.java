package business;

import model.*;
import repository.CourseRepository;
import repository.GradeRepository;
import repository.StudentRepository;
import repository.implementation.CourseRepositoryImpl;
import repository.implementation.GradeRepositoryImpl;
import repository.implementation.StudentRepositoryImpl;

import java.util.List;
import java.util.Map;

public class StudentBusiness {
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;
    private final ContextHolder contextHolder;
    private final CourseRepository courseRepository;

    public StudentBusiness(ContextHolder contextHolder) {
        this.studentRepository = new StudentRepositoryImpl();
        this.gradeRepository = new GradeRepositoryImpl();
        this.contextHolder = contextHolder;
        this.courseRepository = new CourseRepositoryImpl();
    }

    public boolean login(String email, String password) {
        Student student = studentRepository.findByEmail(email);
        if (student != null) {
            if (student.getPassword().equals(password)) {
                contextHolder.setCurrentUser(student);
                return true;
            } else {
                System.out.println("invalid password");
            }
        } else {
            System.out.println("user with email " + email + " not found");
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
        Student student = (Student) contextHolder.getCurrentUser();
        return courseRepository.findByStudentId(student.getStudentId());
    }


    public List<RegisterEntry> viewGrades() {
        Student student = (Student) contextHolder.getCurrentUser();
        System.out.println(student);
        return gradeRepository.findByStudentId(student.getStudentId());
    }
}
