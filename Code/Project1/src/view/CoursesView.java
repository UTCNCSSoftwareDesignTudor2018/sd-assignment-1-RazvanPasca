/*
 * Created by JFormDesigner on Mon Mar 26 01:11:20 EEST 2018
 */

package view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Razvan Pasca
 */
public class CoursesView extends JFrame {
    public CoursesView(AbstractTableModel tableModel) {
        initComponents(tableModel);
    }

    private void initComponents(AbstractTableModel tableModel) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Razvan Pasca
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        enrollButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][]{
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                    },
                    new String[]{
                            null, null, null, null
                    }
            ));
            scrollPane1.setViewportView(table1);
        }

        //---- enrollButton ----
        enrollButton.setText("Enroll me");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(enrollButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 535, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(45, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(enrollButton)
                                .addGap(85, 85, 85))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Razvan Pasca
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton enrollButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public void setTableModel(AbstractTableModel model) {
        this.table1.setModel(model);
    }

    public void addEnrollListener(ActionListener e) {
        this.enrollButton.addActionListener(e);
    }

    public JTable getCourseTable() {
        return this.table1;
    }
}
