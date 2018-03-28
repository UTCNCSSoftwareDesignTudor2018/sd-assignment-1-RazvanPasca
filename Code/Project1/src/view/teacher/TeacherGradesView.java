/*
 * Created by JFormDesigner on Wed Mar 28 12:25:28 EEST 2018
 */

package view.teacher;

import model.Grade;
import model.RegisterEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Razvan Pasca
 */
public class TeacherGradesView extends JFrame {
    public TeacherGradesView() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Razvan Pasca
        registerEntriesComboBox = new JComboBox();
        label1 = new JLabel();
        studentNameField = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        studentGroupField = new JTextField();
        label4 = new JLabel();
        studentGradeField = new JTextField();
        addMarkButton = new JButton();
        updateMarkButton = new JButton();
        courseNameField = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Student Name");

        //---- label2 ----
        label2.setText("Course name");

        //---- label3 ----
        label3.setText("Student Group");

        //---- label4 ----
        label4.setText("Student Grade");

        //---- addMarkButton ----
        addMarkButton.setText("Add mark");

        //---- updateMarkButton ----
        updateMarkButton.setText("Update mark");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(437, Short.MAX_VALUE)
                                .addComponent(registerEntriesComboBox, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                .addGap(154, 154, 154)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(studentNameField, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(courseNameField, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(studentGroupField, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addMarkButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(label4)
                                                        .addComponent(studentGradeField, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(updateMarkButton, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(88, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(registerEntriesComboBox, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(label1)
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(label3)
                                                                .addComponent(label4)))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(studentNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(studentGradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(studentGroupField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addMarkButton)
                                        .addComponent(updateMarkButton)
                                        .addComponent(courseNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(152, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Razvan Pasca
    private JComboBox registerEntriesComboBox;
    private JLabel label1;
    private JTextField studentNameField;
    private JLabel label2;
    private JLabel label3;
    private JTextField studentGroupField;
    private JLabel label4;
    private JTextField studentGradeField;
    private JButton addMarkButton;
    private JButton updateMarkButton;
    private JTextField courseNameField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JComboBox getRegisterEntriesComboBox() {
        return registerEntriesComboBox;
    }


    public String getStudentNameField() {
        return studentNameField.getText();
    }

    public void setStudentNameField(String studentNameField) {
        this.studentNameField.setText(studentNameField);
    }

    public String getStudentGroupField() {
        return studentGroupField.getText();
    }

    public void setStudentGroupField(String studentGroupField) {
        this.studentGroupField.setText(studentGroupField);
    }

    public String getStudentGradeField() {
        return studentGradeField.getText();
    }

    public void setStudentGradeField(String studentGradeField) {
        this.studentGradeField.setText(studentGradeField);
    }

    public void addMarkButtonListener(ActionListener e) {
        addMarkButton.addActionListener(e);
    }


    public void addUpdateMarkButtonListener(ActionListener e) {
        this.updateMarkButton.addActionListener(e);
    }


    public void setComboBoxItems(List<RegisterEntry> registerEntries) {
        for (RegisterEntry registerEntry : registerEntries) {
            registerEntriesComboBox.addItem(registerEntry.getStudent().getName());
        }
    }

    public void populateViewFields(int index, List<RegisterEntry> registerEntries) {
        setStudentGroupField(String.valueOf(registerEntries.get(index).getStudent().getGroup()));
        setStudentNameField(registerEntries.get(index).getStudent().getName());
        setCourseNameField(registerEntries.get(index).getCourse().getName());
        Grade grade = registerEntries.get(index).getGrade();
        if (grade.getGrade() == 0)
            setStudentGradeField("No grade yet");
        else
            setStudentGradeField(String.valueOf(registerEntries.get(index).getGrade().getGrade()));

    }

    public void addComboBoxListener(ActionListener e) {
        this.registerEntriesComboBox.addActionListener(e);
    }

    public void setCourseNameField(String name) {
        this.courseNameField.setText(name);
    }
}
