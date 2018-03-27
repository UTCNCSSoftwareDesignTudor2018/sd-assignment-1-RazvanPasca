package model;

import java.sql.Date;

public class Enrolment {
    private long studentId;
    private long courseId;
    private boolean status;
    private Date requestDate;

    public Enrolment(long studentId, long courseId, boolean status, Date requestDate) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
        this.requestDate = requestDate;
    }

    public Enrolment() {

    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "Enrolment{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                ", status=" + status +
                ", requestDate=" + requestDate +
                '}';
    }
}
