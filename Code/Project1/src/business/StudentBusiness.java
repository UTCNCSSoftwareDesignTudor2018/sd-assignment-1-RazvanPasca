package business;

import model.Course;
import model.Grade;
import model.Student;
import model.User;
import repository.CourseRepository;
import repository.GradeRepository;
import repository.StudentRepository;

import java.util.List;

public class StudentBusiness {
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;
    private final ContextHolder contextHolder;
    private final CourseRepository courseRepository;

    public StudentBusiness(StudentRepository studentRepository, GradeRepository gradeRepository, ContextHolder contextHolder, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
        this.contextHolder = contextHolder;
        this.courseRepository = courseRepository;
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

    public List<Course> viewCourses() {
        Student student = (Student) contextHolder.getCurrentUser();
        return courseRepository.findByStudentId(student.getStudentId());
    }


    public List<Grade> viewGrades() {
        Student student = (Student) contextHolder.getCurrentUser();
        return gradeRepository.findByStudentId(student.getStudentId());
    }
}
