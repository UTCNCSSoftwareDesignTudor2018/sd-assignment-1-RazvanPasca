package test;

import business.ContextHolder;
import business.StudentBusiness;
import repository.CourseRepository;
import repository.StudentRepository;
import repository.implementation.CourseRepositoryImpl;
import repository.implementation.GradeRepositoryImpl;
import repository.implementation.StudentRepositoryImpl;

public class Main {

    public static void main(String args[]) {
        StudentRepository studentRepository = new StudentRepositoryImpl();
//        studentRepository.delete(Long.valueOf(1));
//        Student student = new Student();
//        student.setPassword("asdsadas");
//        student.setGroup(1);
//        student.setAddress("ASffasfsa");
//        student.setCNP("Asdasfsadsa");
//        student.setName("labus");
//        student.setEmail("labus@fanus.com");
//        studentRepository.save(student);
//        List<Student> students = studentRepository.findAll();
//
//        TeacherRepository teacherRepository = new TeacherRepositoryImpl();
//        System.out.println(teacherRepository.findByEmail("rlarson@example.org"));
//        System.out.println(teacherRepository.findAll());
//
//        CourseRepository courseRepository = new CourseRepositoryImpl();
//        Course course = new Course();
//        course.setCourseId(0);
//        course.setName("matematica");
//        course.setTeacherId(18);
//        courseRepository.saveCourse(course);
//        //System.out.println(courseRepository.findById(12));
//        System.out.println(courseRepository.findByName("matematica"));
//        List<Course> courses = courseRepository.findAll();
//
//        EnrolmentRepository enrolmentRepository = new EnrolmentRepositoryImpl();
//        Enrolment enrolment = new Enrolment();
//        enrolment.setRequestDate(new Date(System.currentTimeMillis()));
//        enrolment.setCourseId(12);
//        enrolment.setStatus(true);
//        enrolment.setStudentId(8);
//        enrolmentRepository.saveEnrolment(enrolment);
//        System.out.println(enrolmentRepository.findByStatus(true));
//
////        ExamRepository examRepository = new ExamRepositoryImpl();
////        System.out.println(examRepository.findById(0));
//
//        GradeRepository gradeRepository = new GradeRepositoryImpl();
//        Grade grade = new Grade();
//        grade.setGrade(10);
//        grade.setCourseId(12);
//        grade.setStudentId(8);
//        grade.setDate(new Date(System.currentTimeMillis()));
//        gradeRepository.saveGrade(grade);
//        System.out.println(gradeRepository.findByStudentId(8));
//        List<Grade> grades = gradeRepository.findAll();
//
////        System.out.println(students);
////        System.out.println(teachers);
////        System.out.println(courses);
////        System.out.println(enrolments);
////        System.out.println(exams);

        CourseRepository courseRepository = new CourseRepositoryImpl();
        System.out.println(courseRepository.findByStudentId(2));
        ContextHolder ch = new ContextHolder();
        ch.setCurrentUser(studentRepository.findById(10));
        StudentBusiness sb = new StudentBusiness(new StudentRepositoryImpl(), new GradeRepositoryImpl(), ch, new CourseRepositoryImpl());
        System.out.println(sb.viewGrades());

    }
}
