/*
 * Created by JFormDesigner on Sun Mar 25 23:02:32 EEST 2018
 */

package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Razvan Pasca
 */
public class LoginView extends JFrame{
    public LoginView() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Razvan Pasca
        label2 = new JLabel();
        emailField = new JTextField();
        label3 = new JLabel();
        passwordField = new JPasswordField();
        loginStudentButton = new JButton();
        loginTeacherButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Menu");
        setAlwaysOnTop(true);
        Container contentPane = getContentPane();

        //---- label2 ----
        label2.setText("email");

        //---- label3 ----
        label3.setText("password");

        //---- loginStudentButton ----
        loginStudentButton.setText("Login as Student");

        //---- loginTeacherButton ----
        loginTeacherButton.setText("Login as Teacher");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3))
                            .addGap(82, 82, 82)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(emailField, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(loginStudentButton)
                            .addGap(62, 62, 62)
                            .addComponent(loginTeacherButton)))
                    .addContainerGap(50, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label2)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(loginStudentButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addComponent(loginTeacherButton, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(51, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Razvan Pasca
    private JLabel label2;
    private JTextField emailField;
    private JLabel label3;
    private JPasswordField passwordField;
    private JButton loginStudentButton;
    private JButton loginTeacherButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void addStudentLoginListener(ActionListener e) {
        loginStudentButton.addActionListener(e);
    }

    public void addTeacherLoginListener(ActionListener e) {
        loginTeacherButton.addActionListener(e);
    }

    public String getEmailField() {
        return emailField.getText();
    }

    public String getPasswordField() {
        return String.valueOf(passwordField.getPassword());
    }

    public void setEmailField(String text){
        emailField.setText(text);
    }

}
