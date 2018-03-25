/*
 * Created by JFormDesigner on Sun Mar 25 23:30:40 EEST 2018
 */

package view.student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Razvan Pasca
 */
public class StudentMenuView extends JFrame {
    public StudentMenuView() {
        initComponents();
        this.setVisible(true);
    }

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

    public void addUpdateProfileListener(ActionListener e) {
        updateProfileButton.addActionListener(e);
    }

    public void addViewCoursesListener(ActionListener e) {
        viewCoursesButton.addActionListener(e);
    }

    public void addViewGradesListener(ActionListener e) {
        viewGradesButton.addActionListener(e);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Razvan Pasca
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        updateProfileButton = new JButton();
        viewCoursesButton = new JButton();
        viewGradesButton = new JButton();
        nameTextField = new JTextField();
        emailTextField = new JTextField();
        addressTextField = new JTextField();
        groupTextField = new JTextField();
        CNPTextField = new JTextField();

        //======== this ========
        setTitle("Student Menu");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("name");

        //---- label2 ----
        label2.setText("email");

        //---- label3 ----
        label3.setText("address");

        //---- label4 ----
        label4.setText("group");

        //---- label5 ----
        label5.setText("CNP");

        //---- updateProfileButton ----
        updateProfileButton.setText("update profile");

        //---- viewCoursesButton ----
        viewCoursesButton.setText("view courses");

        //---- viewGradesButton ----
        viewGradesButton.setText("view grades");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(updateProfileButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(viewCoursesButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(viewGradesButton, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                                                .addComponent(label2)
                                                                .addComponent(label3)
                                                                .addComponent(label4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                                        .addComponent(label5))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                                                        .addComponent(emailTextField)
                                                        .addComponent(addressTextField)
                                                        .addComponent(groupTextField)
                                                        .addComponent(CNPTextField))))
                                .addContainerGap(145, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label1)
                                        .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label2)
                                        .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label3)
                                        .addComponent(addressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label4)
                                        .addComponent(groupTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label5)
                                        .addComponent(CNPTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(updateProfileButton)
                                        .addComponent(viewCoursesButton)
                                        .addComponent(viewGradesButton))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Razvan Pasca
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JButton updateProfileButton;
    private JButton viewCoursesButton;
    private JButton viewGradesButton;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField addressTextField;
    private JTextField groupTextField;
    private JTextField CNPTextField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
