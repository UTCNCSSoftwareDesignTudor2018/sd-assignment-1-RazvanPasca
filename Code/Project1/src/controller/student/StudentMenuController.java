package controller.student;

import business.StudentBusiness;
import controller.StudentCoursesListener;
import controller.StudentGradesListener;
import model.Course;
import model.RegisterEntry;
import model.Student;
import model.Teacher;
import view.CoursesTableModel;
import view.CoursesView;
import view.student.StudentGradeView;
import view.student.StudentMenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentMenuController {
    private StudentBusiness studentBusiness;
    private StudentMenuView studentMenuView;


    public StudentMenuController(StudentBusiness studentBusiness, StudentMenuView studentMenuView) {
        this.studentBusiness = studentBusiness;
        this.studentMenuView = studentMenuView;
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
        });

        //add listener to open the courses window which allows the student to enroll on a selected course
        //if not already enrolled
        this.studentMenuView.addViewCoursesListener(e -> {
            Map<Course, Teacher> courses = studentBusiness.viewCourses();
            CoursesTableModel coursesTableModel = new CoursesTableModel(new ArrayList<Teacher>(courses.values()),
                    new ArrayList<Course>(courses.keySet()), 10);
            CoursesView coursesView = new CoursesView(coursesTableModel);
            coursesView.setTableModel(coursesTableModel);
            coursesView.setVisible(true);

            //have a separate class for courses listener
            coursesView.addEnrollListener(new StudentCoursesListener(coursesView.getCourseTable(), studentBusiness));
        });


        //add listener for viewing grades
        //together with opening the new view
        //and adding combobox listener
        this.studentMenuView.addViewGradesListener(e -> {
                    List<RegisterEntry> registerEntries = studentBusiness.viewGrades();
                    StudentGradeView studentGradeView = new StudentGradeView();
                    studentGradeView.setComboBoxItems(registerEntries);
                    studentGradeView.setVisible(true);

                    studentGradeView.addComboBoxListener(new StudentGradesListener(studentGradeView.getCourseSelectionBox(),
                            registerEntries, studentGradeView));
                }
        );


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
