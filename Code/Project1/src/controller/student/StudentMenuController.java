package controller.student;

import business.StudentBusiness;
import controller.listener.StudentCoursesListener;
import controller.listener.StudentGradesListener;
import controller.validator.CNPValidator;
import controller.validator.EmailValidator;
import controller.validator.GeneralStringValidator;
import model.Course;
import model.RegisterEntry;
import model.Student;
import model.Teacher;
import view.CoursesTableModel;
import view.student.StudentCoursesView;
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
            EmailValidator emailValidator = new EmailValidator();
            GeneralStringValidator generalStringValidator = new GeneralStringValidator();
            CNPValidator cnpValidator = new CNPValidator();
            if (emailValidator.validate(studentMenuView.getEmailTextField()) &&
                    generalStringValidator.validate(studentMenuView.getNameTextField()) &&
                    cnpValidator.validate(studentMenuView.getCNPTextField()) &&
                    generalStringValidator.validate(studentMenuView.getAddressTextField())
                    ) {
                student.setEmail(studentMenuView.getEmailTextField());
                student.setName(studentMenuView.getNameTextField());
                student.setCNP(studentMenuView.getCNPTextField());
                student.setAddress(studentMenuView.getAddressTextField());
            } else
                studentMenuView.setNameTextField("Invalid fields entered");
        });

        //add listener to open the courses window which allows the student to enroll on a selected course
        //if not already enrolled
        this.studentMenuView.addViewCoursesListener(e -> {
            Map<Course, Teacher> courses = studentBusiness.viewCourses();
            CoursesTableModel coursesTableModel = new CoursesTableModel(new ArrayList<Teacher>(courses.values()),
                    new ArrayList<Course>(courses.keySet()), 10);
            StudentCoursesView coursesView = new StudentCoursesView(coursesTableModel);
            coursesView.setTableModel(coursesTableModel);

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
            studentGradeView.addComboBoxListener(new StudentGradesListener(registerEntries, studentGradeView));
                }
        );

    }

    private void initializeViewFields() {
        Student student = (Student) studentBusiness.viewProfile();
        studentMenuView.setNameTextField(student.getName());
        studentMenuView.setAddressTextField(student.getAddress());
        studentMenuView.setCNPTextField(student.getCNP());
        studentMenuView.setEmailTextField(student.getEmail());
        studentMenuView.setGroupTextField(String.valueOf(student.getGroup()));
    }
}
