package model;

public class Teacher implements User {
    private long teacherId;
    private String name;
    private String email;
    private String password;

    public Teacher(Teacher currentUser) {
        this.teacherId = currentUser.teacherId;
        this.name = currentUser.name;
        this.email = currentUser.email;
        this.password = currentUser.password;
    }

    public Teacher() {
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
