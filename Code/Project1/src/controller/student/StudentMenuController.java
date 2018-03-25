package controller.student;

import business.StudentBusiness;
import model.Student;
import view.student.StudentMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMenuController {
    private StudentBusiness studentBusiness;
    private StudentMenuView studentMenuView;

    public StudentMenuController(StudentBusiness studentBusiness, StudentMenuView studentMenuView) {
        this.studentBusiness = studentBusiness;
        this.studentMenuView = studentMenuView;
        this.addListeners();

    }

    private void addListeners() {
        this.studentMenuView.addUpdateProfileListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void initializeViewFields() {
        Student student = (Student) studentBusiness.viewProfile();
        studentMenuView.setNameTextField(student.getName());
    }
}
