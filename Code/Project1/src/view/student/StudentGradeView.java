/*
 * Created by JFormDesigner on Tue Mar 27 20:30:48 EEST 2018
 */

package view.student;

import business.ContextHolder;
import model.Course;
import model.RegisterEntry;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Razvan Pasca
 */
public class StudentGradeView extends JFrame {
    public StudentGradeView() {
        initComponents();
        setVisible(true);
        this.studentNameLabel.setText(ContextHolder.getCurrentUser().getName());

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Razvan Pasca
        courseSelectionBox = new JComboBox();
        courseTeacherName = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        courseTeacherEmail = new JTextField();
        label4 = new JLabel();
        courseGrade = new JTextField();
        label5 = new JLabel();
        examDate = new JTextField();
        studentNameLabel = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Course teacher");

        //---- label2 ----
        label2.setText("Course teacher email");

        //---- label4 ----
        label4.setText("Course grade");

        //---- label5 ----
        label5.setText("Exam date");

        //---- studentNameLabel ----
        studentNameLabel.setFont(studentNameLabel.getFont().deriveFont(studentNameLabel.getFont().getStyle() | Font.BOLD, studentNameLabel.getFont().getSize() + 7f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(courseTeacherName, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.Alignment.LEADING)
                            .addComponent(courseTeacherEmail, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                        .addComponent(courseSelectionBox, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
                    .addGap(113, 113, 113)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label4)
                        .addComponent(courseGrade, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                        .addComponent(label5)
                        .addComponent(examDate, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                        .addComponent(studentNameLabel, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(68, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(courseSelectionBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(studentNameLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(label4))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(courseTeacherName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(courseGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(courseTeacherEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(examDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(293, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Razvan Pasca
    private JComboBox courseSelectionBox;
    private JTextField courseTeacherName;
    private JLabel label1;
    private JLabel label2;
    private JTextField courseTeacherEmail;
    private JLabel label4;
    private JTextField courseGrade;
    private JLabel label5;
    private JTextField examDate;
    private JLabel studentNameLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public void setCourseTeacherName(String name) {
        if (name == null)
            this.courseTeacherName.setText("");
        this.courseTeacherName.setText(name);
    }

    public void setCourseTeacherEmail(String email) {
        if (email == null)
            this.courseTeacherEmail.setText("");
        this.courseTeacherEmail.setText(email);
    }


    public void setCourseGrade(int grade) {
        if (grade == 0)
            this.courseGrade.setText("No grade yet");
        else
            this.courseGrade.setText(String.valueOf(grade));
    }

    public void setExamDate(Date date) {
        if (date == null)
            this.examDate.setText("No exam has been taken");
        else
            this.examDate.setText(date.toString());
    }

    public void setComboBoxItems(List<RegisterEntry> entries) {
        for (RegisterEntry entry : entries)
            this.courseSelectionBox.addItem(entry.getCourse().getName());
    }

    public void addComboBoxListener(ActionListener e) {
        this.courseSelectionBox.addActionListener(e);
    }

    public JComboBox getCourseSelectionBox() {
        return this.courseSelectionBox;
    }

    public void populateViewFields(int index, List<RegisterEntry> registerEntries) {
        this.setCourseGrade(registerEntries.get(index).getGrade().getGrade());
        this.setExamDate(registerEntries.get(index).getGrade().getDate());
        this.setCourseTeacherName(registerEntries.get(index).getTeacher().getName());
        this.setCourseTeacherEmail(registerEntries.get(index).getTeacher().getEmail());
        this.studentNameLabel.setText(ContextHolder.getCurrentUser().getName());
    }
}
