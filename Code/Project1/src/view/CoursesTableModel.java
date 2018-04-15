package view;

import model.Course;
import model.Teacher;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CoursesTableModel extends AbstractTableModel {

    private String[] columnNames = {"Course id", "Course name", "Teacher name", "Teacher email"};
    private List<Course> courses ;
    private List<Teacher> teachers;


    public CoursesTableModel(List<Teacher> ts,List<Course> cs, int nrOfRows) {

//        this.courses = new ArrayList<Course>(data.keySet());
//        this.teachers = new ArrayList<Teacher>(data.values());
        this.courses = cs;
        this.teachers = ts;
    }


    @Override
    public int getRowCount() {
        return this.teachers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0)
            return Integer.class;
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object returnValue = null;
        switch (columnIndex) {
            case 0:
                returnValue = courses.get(rowIndex).getCourseId();
                break;
            case 1:
                returnValue = courses.get(rowIndex).getName();
                break;
            case 2:
                returnValue = teachers.get(rowIndex).getName();
                break;
            case 3:
                returnValue = teachers.get(rowIndex).getEmail();
                break;
            default:
                throw new IllegalArgumentException("Invalid column index");
        }
        return returnValue;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                courses.get(rowIndex).setCourseId((Long) aValue);
                break;
            case 1:
                courses.get(rowIndex).setName((String) aValue);
                break;
            case 2:
                teachers.get(rowIndex).setName((String) aValue);
                break;
            case 3:
                teachers.get(rowIndex).setEmail((String) aValue);
                break;
            default:
                throw new IllegalArgumentException("Invalid column index");
        }
    }

    public List<Teacher> getTeachers(){
        return this.teachers;
    }

    public List<Course> getCourses(){
        return this.courses;
    }
}
