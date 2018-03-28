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

    public static class Builder {
        private String address = "default";
        private String password = "default";
        private String CNP = "default";
        private String email;
        private String name;
        private int group;
        private long id = 0;

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setCNP(String CNP) {
            this.CNP = CNP;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setGroup(int group) {
            this.group = group;
            return this;
        }

        public Student build() {
            return new Student(this);
        }


    }

    private Student(Builder builder) {
        name = builder.name;
        CNP = builder.CNP;
        address = builder.address;
        email = builder.email;
        group = builder.group;
        studentId = builder.id;
        password = builder.password;
    }
}
