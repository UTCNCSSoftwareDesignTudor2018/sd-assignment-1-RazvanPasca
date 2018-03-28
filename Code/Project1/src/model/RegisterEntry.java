package model;

public class RegisterEntry {
    Student student;
    Course course;
    Teacher teacher;
    Grade grade;

    public RegisterEntry(Student student, Course course, Teacher teacher, Grade grade) {
        this.student = student;
        this.course = course;
        this.teacher = teacher;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student name:" + student.getName() + " " + "Course name:" + course.getName() + " " +
                "Grade:" + grade.getGrade() + " " + "Teacher:" + teacher.getName() +
                " Date:" + grade.getDate() + "\n";
    }
}
