package controller.teacher;

import business.TeacherBusiness;
import controller.validator.GradeAndGroupValidator;
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
            GradeAndGroupValidator gradeAndGroupValidator = new GradeAndGroupValidator();
            if (gradeAndGroupValidator.validate(gradesView.getStudentGradeField())) {
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
                    System.out.println("The grade has not been updated");
                }
            } else
                gradesView.setStudentGradeField("Not a valid grade entry");

        });

        //listener for updating the mark for a student
        gradesView.addUpdateMarkButtonListener(e -> {
            GradeAndGroupValidator gradeAndGroupValidator = new GradeAndGroupValidator();
            if (gradeAndGroupValidator.validate(gradesView.getStudentGradeField())) {
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
                    System.out.println("The grade has not been updated");
                }
            } else {
                gradesView.setStudentGradeField("Not a valid grade entry");
            }

        });


        gradesView.addComboBoxListener(i -> {
            gradesView.populateViewFields(gradesView.getRegisterEntriesComboBox().getSelectedIndex(), entries);
        });
    }


}
