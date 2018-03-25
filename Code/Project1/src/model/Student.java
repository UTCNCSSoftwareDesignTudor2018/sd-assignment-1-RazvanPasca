package model;

public class Student implements User {
    private long studentId;
    private String name;
    private String email;
    private String CNP;
    private String password;
    private String address;
    private int group;

    public Student(Student student) {
        this.studentId = student.getStudentId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.CNP = student.getCNP();
        this.password = student.getPassword();
        this.address = student.getAddress();
        this.group = student.getGroup();
    }

    public Student() {
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", CNP='" + CNP + '\'' +
                ", address='" + address + '\'' +
                ", group=" + group +
                '}';
    }
}
