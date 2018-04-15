package controller.teacher;

import business.TeacherBusiness;
import controller.validator.CNPValidator;
import controller.validator.EmailValidator;
import controller.validator.GeneralStringValidator;
import controller.validator.GradeAndGroupValidator;
import model.Student;
import view.teacher.TeacherStudentsView;

import javax.swing.*;
import java.util.List;

public class TeacherStudentsController {

    private List<Student> students;
    private TeacherStudentsView teacherStudentsView;
    private TeacherBusiness teacherBusiness;


    public TeacherStudentsController(List<Student> students, TeacherStudentsView studentsView, TeacherBusiness teacherBusiness) {
        this.students = students;
        this.teacherStudentsView = studentsView;
        this.teacherBusiness = teacherBusiness;
        teacherStudentsView.setComboBoxItems(students);
        addListeners();
    }

    private void addListeners() {

        //update button listener
        addUpdateListener();

        addComboBoxListener();

        //create student listener
        addCreateListener();

        //delete student listener
        addDeleteListener();

        addReportListener();

    }

    private void addReportListener() {
        teacherStudentsView.addReportListener(e -> {
            Student student = students.get(teacherStudentsView.getStudentsComboBox().getSelectedIndex());
            if (!teacherBusiness.generateStudentReport(student))
                teacherStudentsView.setNameTextField("Report output encountered an error");
        });
    }

    private void addDeleteListener() {
        teacherStudentsView.addDeleteListener(e -> {
            Student student = new Student();
            int index = teacherStudentsView.getStudentsComboBox().getSelectedIndex();
            student.setStudentId(students.get(index).getStudentId());
            System.out.println(student);
            if (teacherBusiness.deleteStudent(student)) {
                System.out.println("student has been deleted successfully");
                students.remove(index);
            } else {
                System.out.println("no student has been deleted");
            }
        });
    }

    private void addCreateListener() {
        teacherStudentsView.addCreateListener(e -> {

            GeneralStringValidator generalStringValidator = new GeneralStringValidator();
            CNPValidator cnpValidator = new CNPValidator();
            EmailValidator emailValidator = new EmailValidator();
            GradeAndGroupValidator gradeAndGroupValidator = new GradeAndGroupValidator();

            if (generalStringValidator.validate(teacherStudentsView.getNameTextField()) &&
                    cnpValidator.validate(teacherStudentsView.getCNPTextField()) &&
                    emailValidator.validate(teacherStudentsView.getEmailTextField()) &&
                    gradeAndGroupValidator.validate(teacherStudentsView.getGroupTextField())) {
                Student student = new Student.Builder().setCNP(teacherStudentsView.getCNPTextField()).
                        setName(teacherStudentsView.getNameTextField()).setAddress(teacherStudentsView.getAddressTextField()).
                        setEmail(teacherStudentsView.getEmailTextField()).
                        setGroup(Integer.parseInt(teacherStudentsView.getGroupTextField())).build();
                System.out.println(student);
                if (teacherBusiness.createStudent(student)) {
                    System.out.println("student has been created successfully");
                    students.add(student);
                } else {
                    System.out.println("no student has been created");
                }
            } else
                teacherStudentsView.setNameTextField("Invalid fields entered");
        });
    }

    private void addComboBoxListener() {
        teacherStudentsView.addComboBoxListener(e -> {
            teacherStudentsView.populateViewFields(teacherStudentsView.getStudentsComboBox().getSelectedIndex(), students);
        });
    }

    private void addUpdateListener() {
        teacherStudentsView.addUpdateListener(e -> {

            GeneralStringValidator generalStringValidator = new GeneralStringValidator();
            CNPValidator cnpValidator = new CNPValidator();
            EmailValidator emailValidator = new EmailValidator();
            GradeAndGroupValidator gradeAndGroupValidator = new GradeAndGroupValidator();

            if (generalStringValidator.validate(teacherStudentsView.getNameTextField()) &&
                    cnpValidator.validate(teacherStudentsView.getCNPTextField()) &&
                    emailValidator.validate(teacherStudentsView.getEmailTextField()) &&
                    gradeAndGroupValidator.validate(teacherStudentsView.getGroupTextField())) {
                int index = teacherStudentsView.getStudentsComboBox().getSelectedIndex();

                Student student = new Student.Builder().setCNP(teacherStudentsView.getCNPTextField()).
                        setName(teacherStudentsView.getNameTextField()).setAddress(teacherStudentsView.getAddressTextField()).
                        setEmail(teacherStudentsView.getEmailTextField()).
                        setGroup(Integer.parseInt(teacherStudentsView.getGroupTextField())).
                        setPassword(students.get(index).getPassword()).
                        setId(students.get(index).getStudentId()).build();

                System.out.println(student);

                if (teacherBusiness.updateStudent(student)) {
                    System.out.println("student has been updated successfully");
                    students.set(index, student);
                } else {
                    System.out.println("no student has been updated");
                }
            }
        });
    }


}
