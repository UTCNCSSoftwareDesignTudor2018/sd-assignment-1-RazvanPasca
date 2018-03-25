import business.ContextHolder;
import business.StudentBusiness;
import controller.student.StudentLoginController;

import java.awt.*;

public class Main {

    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {

                StudentBusiness studentBusiness = new StudentBusiness(new ContextHolder());
                StudentLoginController studentLoginController = new StudentLoginController(studentBusiness);

            }
        });
    }
}
