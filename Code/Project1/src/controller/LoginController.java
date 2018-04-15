package controller;


import business.ContextHolder;
import business.StudentBusiness;
import business.TeacherBusiness;
import controller.student.StudentMenuController;
import controller.teacher.TeacherMenuController;
import controller.validator.EmailValidator;
import view.LoginView;
import view.student.StudentMenuView;
import view.teacher.TeacherMenuView;

public class LoginController {
    private StudentBusiness studentBusiness;
    private TeacherBusiness teacherBusiness;
    private ContextHolder contextHolder;
    private LoginView loginView;

    public LoginController(StudentBusiness userBusiness, TeacherBusiness teacherBusiness, LoginView loginView) {
        this.studentBusiness = userBusiness;
        this.teacherBusiness = teacherBusiness;
        this.loginView = loginView;
        this.addListeners();
    }

    private void addListeners() {
        loginView.addStudentLoginListener(e -> {

            EmailValidator emailValidator = new EmailValidator();
            String email = loginView.getEmailField();
            String password = loginView.getPasswordField();
            if (emailValidator.validate(email))
                if (studentBusiness.login(email, password)) {
                    loginView.dispose();
                    StudentMenuView studentMenuView = new StudentMenuView();
                    StudentMenuController studentMenuController = new StudentMenuController(studentBusiness, studentMenuView);
                } else {
                    loginView.setEmailField("Invalid username/password");
                }
            else {
                loginView.setEmailField("Invalid email format");
            }
        });

        loginView.addTeacherLoginListener(e -> {
            String email = loginView.getEmailField();
            String password = loginView.getPasswordField();

            EmailValidator emailValidator = new EmailValidator();
            if (emailValidator.validate(email))
                if (teacherBusiness.login(email, password)) {
                    loginView.dispose();
                    TeacherMenuView teacherMenuView = new TeacherMenuView();
                    TeacherMenuController teacherMenuController = new TeacherMenuController(teacherBusiness, teacherMenuView);
                } else {
                    loginView.setEmailField("Invalid username/password");
                }
            else {
                loginView.setEmailField("Invalid email format");
            }
        });
    }
}
