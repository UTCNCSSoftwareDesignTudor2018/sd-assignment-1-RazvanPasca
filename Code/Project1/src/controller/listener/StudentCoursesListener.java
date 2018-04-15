package controller.listener;

import business.StudentBusiness;
import model.Course;
import view.CoursesTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentCoursesListener implements ActionListener {

    private JTable coursesTable;
    private StudentBusiness studentBusiness;

    public StudentCoursesListener(JTable table, StudentBusiness studentBusiness){
        this.coursesTable = table;
        this.studentBusiness = studentBusiness;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int rowIndex = coursesTable.getSelectedRow();
        CoursesTableModel coursesTableModel = (CoursesTableModel) coursesTable.getModel();
        Course course = coursesTableModel.getCourses().get(rowIndex);
        studentBusiness.enroll(course.getCourseId());
    }
}
