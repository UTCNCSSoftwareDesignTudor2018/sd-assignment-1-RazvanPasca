package controller.listener;

import model.RegisterEntry;
import view.student.StudentGradeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentGradesListener implements ActionListener {
    private StudentGradeView studentGradeView;
    private List<RegisterEntry> registerEntries;

    public StudentGradesListener(List<RegisterEntry> registerEntries,
                                 StudentGradeView studentGradeView) {
        studentGradeView.getCourseSelectionBox().setSelectedIndex(0);
        this.studentGradeView = studentGradeView;
        this.registerEntries = registerEntries;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = studentGradeView.getCourseSelectionBox().getSelectedIndex();
        studentGradeView.populateViewFields(selectedIndex,registerEntries);

    }


}
