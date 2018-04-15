package controller.teacher;

import business.ContextHolder;
import business.TeacherBusiness;
import controller.validator.EmailValidator;
import controller.validator.GeneralStringValidator;
import model.RegisterEntry;
import model.Student;
import model.Teacher;
import view.teacher.TeacherGradesView;
import view.teacher.TeacherMenuView;
import view.teacher.TeacherStudentsView;

import java.util.List;

public class TeacherMenuController {

    private TeacherBusiness teacherBusiness;
    private TeacherMenuView teacherMenuView;

    public TeacherMenuController(TeacherBusiness teacherBusiness, TeacherMenuView teacherMenuView) {
        this.teacherBusiness = teacherBusiness;
        this.teacherMenuView = teacherMenuView;
        addListeners();
        initializeViewFields();
    }

    private void initializeViewFields() {
        Teacher teacher = (Teacher) teacherBusiness.viewProfile();
        teacherMenuView.setNameTextField(teacher.getName());
        teacherMenuView.setEmailTextField(teacher.getEmail());
    }

    private void addListeners() {
        teacherMenuView.addUpdateProfileListener(e -> {
            Teacher teacher = new Teacher((Teacher) ContextHolder.getCurrentUser());
            EmailValidator emailValidator = new EmailValidator();
            GeneralStringValidator generalStringValidator = new GeneralStringValidator();
            String email = teacherMenuView.getEmailTextField();
            String name = teacherMenuView.getNameTextField();
            if (emailValidator.validate(email) && generalStringValidator.validate(name)) {
                teacher.setEmail(email);
                teacher.setName(name);
                teacherBusiness.updateProfile(teacher);
            }
            else {
                teacherMenuView.setNameTextField("invalid name");
                teacherMenuView.setEmailTextField("or email");
            }
        });

        teacherMenuView.addViewStudentsListener(e -> {
            List<Student> students = teacherBusiness.viewStudents();
            TeacherStudentsView studentsView = new TeacherStudentsView();
            TeacherStudentsController teacherStudentsController = new TeacherStudentsController(students,
                    studentsView, teacherBusiness);
        });

        teacherMenuView.addViewGradesListener(e -> {
            List<RegisterEntry> entries = teacherBusiness.getEnrolledStudents();
            TeacherGradesView gradesView = new TeacherGradesView();
            TeacherGradesController teacherGradesController = new TeacherGradesController(entries, gradesView,
                    teacherBusiness);
        });
    }
}
