import business.ContextHolder;
import business.business.implementation.StudentBusinessImpl;
import controller.LoginController;
import view.student.LoginView;

import java.awt.*;

public class Main {

    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView loginView = new LoginView();
                StudentBusinessImpl studentBusiness = new StudentBusinessImpl(new ContextHolder());
                LoginController loginController = new LoginController(studentBusiness, loginView);

            }
        });
    }
}
