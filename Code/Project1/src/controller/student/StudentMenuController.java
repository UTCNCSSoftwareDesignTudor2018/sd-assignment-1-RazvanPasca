package controller.student;

import business.EnrolmentBusiness;
import business.StudentBusiness;
import model.Course;
import model.Student;
import model.Teacher;
import view.CoursesTableModel;
import view.CoursesView;
import view.student.StudentMenuView;

import java.util.ArrayList;
import java.util.Map;

public class StudentMenuController {
    private StudentBusiness studentBusiness;
    private StudentMenuView studentMenuView;
    private EnrolmentBusiness enrolmentBusiness;

    public StudentMenuController(StudentBusiness studentBusiness, StudentMenuView studentMenuView, EnrolmentBusiness enrolmentBusiness) {
        this.studentBusiness = studentBusiness;
        this.studentMenuView = studentMenuView;
        this.enrolmentBusiness = enrolmentBusiness;

        this.addListeners();
        this.initializeViewFields();

    }

    private void addListeners() {
        this.studentMenuView.addUpdateProfileListener(e -> {
            Student student = new Student((Student) studentBusiness.viewProfile());
            student.setEmail(studentMenuView.getEmailTextField());
            student.setName(studentMenuView.getNameTextField());
            student.setCNP(studentMenuView.getCNPTextField());
            student.setAddress(studentMenuView.getAddressTextField());
            System.out.println(student);
            System.out.println(studentBusiness.updateProfile(student));
        });


        this.studentMenuView.addViewCoursesListener(e -> {
            Map<Course, Teacher> courses = studentBusiness.viewCourses();
            CoursesTableModel coursesTableModel = new CoursesTableModel(new ArrayList<Teacher>(courses.values()),
                    new ArrayList<Course>(courses.keySet()), 10);
            // courses.forEach((k,v)-> System.out.println("course " + k + " teacher " + v));
            CoursesView coursesView = new CoursesView(coursesTableModel);
//            coursesView.addTableContent(new CoursesTableModel(new ArrayList<Teacher>(courses.values()),
//                    new ArrayList<Course>(courses.keySet()),10));
            coursesView.setTableModel(coursesTableModel);
            coursesView.setVisible(true);

            coursesView.addEnrollListener(new StudentCoursesListener(coursesView.getCourseTable(), enrolmentBusiness));


        });


    }

    /*TODO
     * implement the view grades functionality, together with the view courses aka:
     * show all enrolled courses and also the grades where it is necessary*/

    private void initializeViewFields() {
        Student student = (Student) studentBusiness.viewProfile();
        studentMenuView.setNameTextField(student.getName());
        studentMenuView.setAddressTextField(student.getAddress());
        studentMenuView.setCNPTextField(student.getCNP());
        studentMenuView.setEmailTextField(student.getEmail());
        studentMenuView.setGroupTextField(String.valueOf(student.getGroup()));
    }
}
