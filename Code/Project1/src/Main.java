import business.ContextHolder;
import business.StudentBusiness;
import business.TeacherBusiness;
import business.implementation.StudentBusinessImpl;
import business.implementation.TeacherBusinessImpl;
import controller.LoginController;
import view.LoginView;

import java.awt.*;

public class Main {

    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView loginView = new LoginView();
                ContextHolder ch = new ContextHolder();
                StudentBusiness studentBusiness = new StudentBusinessImpl(ch);
                TeacherBusiness teacherBusiness = new TeacherBusinessImpl(ch);
                LoginController loginController = new LoginController(studentBusiness, teacherBusiness, loginView);
            }
        });
    }
}
