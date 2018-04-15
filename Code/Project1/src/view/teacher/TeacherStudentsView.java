/*
 * Created by JFormDesigner on Tue Mar 27 23:42:57 EEST 2018
 */

package view.teacher;

import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Razvan Pasca
 */
public class TeacherStudentsView extends JFrame {
    public TeacherStudentsView() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Razvan Pasca
        updateStudentButton = new JButton();
        deleteStudentButton = new JButton();
        createStudentButton = new JButton();
        studentsComboBox = new JComboBox();
        label1 = new JLabel();
        nameTextField = new JTextField();
        label2 = new JLabel();
        emailTextField = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        addressTextField = new JTextField();
        groupTextField = new JTextField();
        label5 = new JLabel();
        CNPTextField = new JTextField();
        generateReportButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- updateStudentButton ----
        updateStudentButton.setText("Update student");

        //---- deleteStudentButton ----
        deleteStudentButton.setText("Delete Student");

        //---- createStudentButton ----
        createStudentButton.setText("Create Student");

        //---- label1 ----
        label1.setText("Name");

        //---- label2 ----
        label2.setText("Email");

        //---- label3 ----
        label3.setText("Address");

        //---- label4 ----
        label4.setText("Group");

        //---- label5 ----
        label5.setText("CNP");

        //---- generateReportButton ----
        generateReportButton.setText("Generate Report");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label1)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                .addComponent(emailTextField, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                .addComponent(updateStudentButton, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                            .addGap(43, 43, 43)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(groupTextField, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label4))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label3)
                                        .addComponent(addressTextField, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                        .addComponent(deleteStudentButton, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                                    .addGap(39, 39, 39)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label5)
                                        .addComponent(createStudentButton, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .addComponent(CNPTextField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                    .addGap(34, 34, 34)
                                    .addComponent(generateReportButton, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(518, Short.MAX_VALUE)
                            .addComponent(studentsComboBox, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)))
                    .addGap(32, 32, 32))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(studentsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label3)
                        .addComponent(label5))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(CNPTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(label4))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(groupTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(104, 104, 104)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE, false)
                        .addComponent(createStudentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteStudentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateStudentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(generateReportButton))
                    .addContainerGap(49, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Razvan Pasca
    private JButton updateStudentButton;
    private JButton deleteStudentButton;
    private JButton createStudentButton;
    private JComboBox studentsComboBox;
    private JLabel label1;
    private JTextField nameTextField;
    private JLabel label2;
    private JTextField emailTextField;
    private JLabel label3;
    private JLabel label4;
    private JTextField addressTextField;
    private JTextField groupTextField;
    private JLabel label5;
    private JTextField CNPTextField;
    private JButton generateReportButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public String getNameTextField() {
        return nameTextField.getText();
    }

    public void setNameTextField(String nameTextField) {
        this.nameTextField.setText(nameTextField);
    }

    public String getEmailTextField() {
        return emailTextField.getText();
    }

    public void setEmailTextField(String emailTextField) {
        this.emailTextField.setText(emailTextField);
    }

    public String getAddressTextField() {
        return addressTextField.getText();
    }

    public void setAddressTextField(String addressTextField) {
        this.addressTextField.setText(addressTextField);
    }

    public String getGroupTextField() {
        return groupTextField.getText();
    }

    public void setGroupTextField(String groupTextField) {
        this.groupTextField.setText(groupTextField);
    }

    public String getCNPTextField() {
        return CNPTextField.getText();
    }

    public void setCNPTextField(String CNPTextField) {
        this.CNPTextField.setText(CNPTextField);
    }

    public void addUpdateListener(ActionListener e) {
        this.updateStudentButton.addActionListener(e);
    }

    public void addDeleteListener(ActionListener e) {
        this.deleteStudentButton.addActionListener(e);
    }

    public void addCreateListener(ActionListener e) {
        this.createStudentButton.addActionListener(e);
    }

    public void populateViewFields(int index, List<Student> students) {
        Student student = students.get(index);
        CNPTextField.setText(student.getCNP());
        groupTextField.setText(String.valueOf(student.getGroup()));
        nameTextField.setText(student.getName());
        emailTextField.setText(student.getEmail());
        addressTextField.setText(student.getAddress());
    }

    public void setComboBoxItems(List<Student> students) {
        for (Student student : students) {
            studentsComboBox.addItem(student.getName());
        }
    }

    public JComboBox getStudentsComboBox() {
        return studentsComboBox;
    }

    public void addComboBoxListener(ActionListener e) {
        this.studentsComboBox.addActionListener(e);
    }

    public void addReportListener(ActionListener e) {
        this.generateReportButton.addActionListener(e);
    }
}
