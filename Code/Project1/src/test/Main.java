package test;

import model.*;
import repository.*;
import repository.implementation.*;

import java.util.List;


public class Main {

    public static void main(String args[]) {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        List<Student> students = studentRepository.findAll();

        TeacherRepository teacherRepository = new TeacherRepositoryImpl();
        List<Teacher> teachers = teacherRepository.findAll();

        CourseRepository courseRepository = new CourseRepositoryImpl();
        List<Course> courses = courseRepository.findAll();

        EnrolmentRepository enrolmentRepository = new EnrolmentRepositoryImpl();
        List<Enrolment> enrolments = enrolmentRepository.findAll();

        ExamRepository examRepository = new ExamRepositoryImpl();
        List<Exam> exams = examRepository.findAll();

        GradeRepository gradeRepository = new GradeRepositoryImpl();
        List<Grade> grades = gradeRepository.findAll();

        System.out.println(students);
        System.out.println(teachers);
        System.out.println(courses);
        System.out.println(enrolments);
        System.out.println(exams);


    }
}
