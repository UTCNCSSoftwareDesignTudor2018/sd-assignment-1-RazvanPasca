package controller.student;


import business.StudentBusiness;
import view.student.StudentLoginView;
import view.student.StudentMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLoginController {
    private StudentBusiness studentBusiness;
    private StudentLoginView studentMenuView;

    public StudentLoginController(StudentBusiness userBusiness) {
        this.studentBusiness = userBusiness;
        StudentLoginView studentMenuView = new StudentLoginView();
        this.studentMenuView = studentMenuView;
        this.addListeners();
    }

    private void addListeners() {
        studentMenuView.addLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = studentMenuView.getEmailField();
                String password = studentMenuView.getPasswordField();
                if (studentBusiness.login(email, password)) {
                    studentMenuView.dispose();
                    StudentMenuView studentMenuView = new StudentMenuView();
                    StudentMenuController studentMenuController = new StudentMenuController(studentBusiness, studentMenuView);
                }
            }
        });
    }
}
