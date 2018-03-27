package controller.student;


import business.EnrolmentBusiness;
import business.StudentBusiness;
import business.business.implementation.EnrolmentBusinessImpl;
import view.student.StudentLoginView;
import view.student.StudentMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLoginController {
    private StudentBusiness studentBusiness;
    private StudentLoginView studentLoginView;

    public StudentLoginController(StudentBusiness userBusiness, StudentLoginView studentLoginView) {
        this.studentBusiness = userBusiness;
        // StudentLoginView studentMenuView = new StudentLoginView();
        this.studentLoginView = studentLoginView;
        this.addListeners();
    }

    private void addListeners() {
        studentLoginView.addLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = studentLoginView.getEmailField();
                String password = studentLoginView.getPasswordField();
                if (studentBusiness.login(email, password)) {
                    studentLoginView.dispose();
                    StudentMenuView studentMenuView = new StudentMenuView();
                    EnrolmentBusiness enrolmentBusiness = new EnrolmentBusinessImpl();
                    StudentMenuController studentMenuController = new StudentMenuController(studentBusiness, studentMenuView, enrolmentBusiness);
                }
            }
        });
    }
}
