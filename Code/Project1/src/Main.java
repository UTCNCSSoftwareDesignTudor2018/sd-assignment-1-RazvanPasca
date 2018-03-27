import business.ContextHolder;
import business.business.implementation.StudentBusinessImpl;
import controller.student.StudentLoginController;
import view.student.StudentLoginView;

import java.awt.*;

public class Main {

    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                StudentLoginView studentLoginView = new StudentLoginView();
                StudentBusinessImpl studentBusiness = new StudentBusinessImpl(new ContextHolder());
                StudentLoginController studentLoginController = new StudentLoginController(studentBusiness, studentLoginView);

            }
        });
    }
}
