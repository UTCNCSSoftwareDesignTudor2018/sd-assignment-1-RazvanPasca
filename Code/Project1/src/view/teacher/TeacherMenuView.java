package view.teacher;/*
 * Created by JFormDesigner on Sun Mar 25 23:30:40 EEST 2018
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Razvan Pasca
 */
public class TeacherMenuView extends JFrame {
    public TeacherMenuView() {
        initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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


    public void addUpdateProfileListener(ActionListener e) {
        updateProfileButton.addActionListener(e);
    }

    public void addViewStudentsListener(ActionListener e) {
        viewStudentsButton.addActionListener(e);
    }

    public void addViewGradesListener(ActionListener e) {
        viewGradesButton.addActionListener(e);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Razvan Pasca
        label1 = new JLabel();
        label2 = new JLabel();
        nameTextField = new JTextField();
        emailTextField = new JTextField();
        updateProfileButton = new JButton();
        viewStudentsButton = new JButton();
        viewGradesButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Name");

        //---- label2 ----
        label2.setText("Email");

        //---- updateProfileButton ----
        updateProfileButton.setText("Update profile");

        //---- viewStudentsButton ----
        viewStudentsButton.setText("View Students");

        //---- viewGradesButton ----
        viewGradesButton.setText("View Grades");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(updateProfileButton, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(viewStudentsButton, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(viewGradesButton)))
                    .addContainerGap(79, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(label1)
                            .addGap(41, 41, 41)
                            .addComponent(label2))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(viewStudentsButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateProfileButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewGradesButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(46, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Razvan Pasca
    private JLabel label1;
    private JLabel label2;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JButton updateProfileButton;
    private JButton viewStudentsButton;
    private JButton viewGradesButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
