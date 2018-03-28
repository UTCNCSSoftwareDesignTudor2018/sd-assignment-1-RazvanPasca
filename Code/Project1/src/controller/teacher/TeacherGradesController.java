package controller.teacher;

import business.TeacherBusiness;
import model.Grade;
import model.RegisterEntry;
import view.teacher.TeacherGradesView;

import java.util.List;

public class TeacherGradesController {

    private List<RegisterEntry> entries;
    private TeacherGradesView gradesView;
    private TeacherBusiness teacherBusiness;

    public TeacherGradesController(List<RegisterEntry> entries, TeacherGradesView gradesView, TeacherBusiness teacherBusiness) {
        this.entries = entries;
        this.gradesView = gradesView;
        this.teacherBusiness = teacherBusiness;
        gradesView.setComboBoxItems(entries);
        addListeners();
    }

    private void addListeners() {
        //listener for entering a new mark for a student
        gradesView.addMarkButtonListener(e -> {
            Grade grade = new Grade();
            int index = gradesView.getRegisterEntriesComboBox().getSelectedIndex();
            grade.setStudentId(entries.get(index).getStudent().getStudentId());
            grade.setCourseId(entries.get(index).getCourse().getCourseId());
            grade.setGrade(Integer.parseInt(gradesView.getStudentGradeField()));
            grade.setDate(new java.sql.Date(System.currentTimeMillis()));
            System.out.println(grade);
            if (teacherBusiness.addGrade(grade)) {
                System.out.println("Grade has been updated");
                entries.get(index).setGrade(grade);
            } else {
                System.out.println("the grade has not been updated");
            }
        });

        //listener for updating the mark for a student
        gradesView.addUpdateMarkButtonListener(e -> {
            Grade grade = new Grade();
            int index = gradesView.getRegisterEntriesComboBox().getSelectedIndex();
            grade.setStudentId(entries.get(index).getStudent().getStudentId());
            grade.setCourseId(entries.get(index).getCourse().getCourseId());
            grade.setGrade(Integer.parseInt(gradesView.getStudentGradeField()));
            grade.setDate(new java.sql.Date(System.currentTimeMillis()));
            System.out.println(grade);
            if (teacherBusiness.updateGrade(grade)) {
                System.out.println("Grade has been updated");
                entries.get(index).setGrade(grade);
            } else {
                System.out.println("the grade has not been updated");
            }
        });


        gradesView.addComboBoxListener(i -> {
            gradesView.populateViewFields(gradesView.getRegisterEntriesComboBox().getSelectedIndex(), entries);
        });
    }


}
